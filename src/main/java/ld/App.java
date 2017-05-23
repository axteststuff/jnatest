package ld;
import java.io.File;
import java.nio.file.Path;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // try {
                System.out.println( "Hello World!" );
                File p = new File("linux-x86-64");
                MyApi.mysys.setenv("LD_LIBRARY_PATH", p.getAbsolutePath() ,1);
                System.out.println(MyApi.mysys.getenv("LD_LIBRARY_PATH"));
                System.out.println(System.getenv("AVAR"));
                System.out.println(MyApi.mysys.getpid());
                System.out.println(MyApi.mysys.getppid());
                long[] timenul = new long[1];
                System.out.println(MyApi.mysys.time(timenul));

                System.loadLibrary("myalloc");
                System.loadLibrary("test");
                System.out.println("yoYo");
                File f = new File("linux-x86-64/libtest.so");
                System.load(f.getAbsolutePath());

/*                int x;
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
*/
//            } catch (UnsatisfiedLinkError e) {
  //              System.out.println("Exception" + e);
    //        }
    }
}
