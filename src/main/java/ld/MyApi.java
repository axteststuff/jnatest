package ld;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;

public class MyApi {
  public interface MySys extends Library {
    public int setenv(String name, String value, int overwrite);
    public int unsetenv(String name);
    public String getenv(String name);
    public int getpid();
    public int getppid();
    public long time(long buf[]);
  }
  static MySys mysys = (MySys) Native.loadLibrary("c", MySys.class);

  interface MyTest extends Library {
      int fun_alloc(PointerByReference p);

      int fun_free(PointerByReference p);

      int setstring(StringByReference str);

      int setvals(MyStruct[] mstructs, int sizeofarray);
  }
  static MyTest mytest = (MyTest) Native.loadLibrary("test", MyTest.class);
}
