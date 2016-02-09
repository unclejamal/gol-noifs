package com.pduda.myjava;

public class MyObject {

    public MyBoolean myEquals(MyObject that) {
        return MyBoolean.convertFromPrimitive(this == that);
    }


    public MyBoolean isInstanceOf(Class clazz) {
        return MyBoolean.convertFromPrimitive(clazz.isInstance(this));
    }
}
