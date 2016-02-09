package com.pduda.myjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyHashSet<T extends MyObject> extends MyObject {
    private final List<T> elements;

    public MyHashSet(List<T> elements) {
        this.elements = elements;
    }

    public static <T extends MyObject> MyHashSet createHashSet(T... elements) {
        return new MyHashSet<>(new ArrayList<>(Arrays.asList(elements)));
    }

    public void add(T element) {
        contains(element)
                .ifFalse(() -> elements.add(element));
    }

    public MyBoolean contains(T element) {
        MyBoolean found = MyBoolean.FALSE;
        for (T t : elements) {
            found = found.or(t.myEquals(element));
        }

        return found;
    }

    public void forEach(Consumer<T> consumer) {
        for (T element : elements) {
            consumer.accept(element);
        }
    }

    @Override
    public MyBoolean myEquals(MyObject object) {
        MyHashSet that = (MyHashSet) object;

        MyBoolean thisIsASubsetOfThat = this.isSubsetOf(that);
        MyBoolean thatIsASubsetOfThis = that.isSubsetOf(this);
        return thisIsASubsetOfThat.and(thatIsASubsetOfThis);
    }

    private MyBoolean isSubsetOf(MyHashSet that) {
        MyBoolean allElementsFoundInThat = MyBoolean.TRUE;
        for (T element : elements) {
            allElementsFoundInThat = allElementsFoundInThat.and(that.contains(element));
        }
        return allElementsFoundInThat;
    }

    public MyInteger count(Function<T, MyBoolean> predicate) {
        MyInteger count = new MyInteger(0);
        for (T element : elements) {
            predicate.apply(element)
                    .ifTrue(() -> count.increment());
        }

        return count;
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "elements=" + elements +
                '}';
    }
}

