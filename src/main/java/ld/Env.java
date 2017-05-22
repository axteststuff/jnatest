package ld;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Env {
  public interface Setenv extends Library {
    public int setenv(String name, String value, int overwrite);
    public int unsetenv(String name);
  }
  static Setenv e = (Setenv) Native.loadLibrary("c", Setenv.class);
}
