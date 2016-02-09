package com.pduda.myjava;

public class MyInteger extends MyObject {
    private int i;

    public MyInteger(int i) {
        this.i = i;
    }

    public void increment() {
        i++;
    }

    public MyInteger distanceTo(MyInteger that) {
        return new MyInteger(Math.abs(i - that.i));
    }

    public MyBoolean isLessOrEqualTo(MyInteger that) {
        return MyBoolean.convertFromPrimitive(i <= that.i);
    }

    @Override
    public MyBoolean myEquals(MyObject object) {
        MyInteger that = (MyInteger) object;
        return MyBoolean.convertFromPrimitive(this.i == that.i);
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
