package ld;

import java.util.List;
import java.util.ArrayList;
import com.sun.jna.Structure;
import com.sun.jna.Pointer;

public class MyStruct extends Structure implements Structure.ByReference {
    public int a;
    public int b;

    public MyStruct() {
    }

    public MyStruct(Pointer p) {
        super(p);
        read();
    }

    public List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        return list;
    }
}