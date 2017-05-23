package ld;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.lang.reflect.Field;
import java.lang.ClassLoader;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void addJavaLibraryPath(String s) throws IOException {
        try {
            // This enables the java.library.path to be modified at runtime
            // From a Sun engineer at http://forums.sun.com/thread.jspa?threadID=707176
            //
            Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
            fieldSysPath.setAccessible( true );
            fieldSysPath.set( null, null );
//            Field field = ClassLoader.class.getDeclaredField("usr_paths");
//            field.setAccessible(true);
//            String[] paths = (String[])field.get(null);
//            for (int i = 0; i < paths.length; i++) {
//                if (s.equals(paths[i])) {
//                    return;
//                }
//            }
//            String[] tmp = new String[paths.length+1];
//            System.arraycopy(paths,0,tmp,0,paths.length);
//            tmp[paths.length] = s;
//            field.set(null,tmp);
            String os=new String(System.getProperty("java.library.path"));
            System.setProperty("java.library.path", s+":"+os);
        } catch (IllegalAccessException e) {
            throw new IOException("Failed to get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException("Failed to get field handle to set library path");
        }
    }

    public static void main( String[] args )
    {
       try {
                System.out.println( "Hello World!" );
                File p = new File("../linux-x86-64");
                MyApi.mysys.setenv("LD_LIBRARY_PATH", p.getAbsolutePath() ,1);
                System.out.println("before java.library.path " + System.getProperty("java.library.path"));
                addJavaLibraryPath(p.getAbsolutePath());
                System.out.println(MyApi.mysys.getenv("LD_LIBRARY_PATH"));
                System.out.println(System.getenv("AVAR"));
                System.out.println(MyApi.mysys.getpid());
                System.out.println(MyApi.mysys.getppid());
                long[] timenul = new long[1];
                System.out.println(MyApi.mysys.time(timenul));

                System.out.println("after java.library.path " + System.getProperty("java.library.path"));
                System.loadLibrary("myalloc");
                System.loadLibrary("test");
                System.out.println("yoYo");

                int x;
                PointerByReference pref = new PointerByReference();
                x = MyApi.mytest.fun_alloc(pref);
                Pointer ptr = pref.getValue();
                MyStruct mys = new MyStruct(ptr);
                System.out.println("Java got from  native "
                        + Pointer.nativeValue(ptr) + "  " + mys.a + " " + mys.b);
                MyApi.mytest.fun_free(pref);
                StringByReference mystring = new StringByReference("ZZZZZ");
                MyApi.mytest.setstring(mystring);
                System.out.println(mystring.getValue());

                MyStruct[] mystructs = new MyStruct[10];
                x = 0;
                while (x < 10) {
                    mystructs[x] = new MyStruct();
                    x++;
                }

                MyApi.mytest.setvals(mystructs, 10);

                x = 0;
                while (x < 10) {
                    System.out.println("Struct no " + x + " values " + mystructs[x].a
                            + " " + mystructs[x].b);
                    x++;
                }

            } catch (UnsatisfiedLinkError e) {
                System.out.println("Exception" + e);
            } catch (IOException e) {
                System.out.println("Exception" + e);
            }
    }
}
