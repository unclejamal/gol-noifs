package com.pduda.myjava;

import java.util.HashMap;
import java.util.Map;

public interface MyBoolean {
    MyBoolean TRUE = new True();
    MyBoolean FALSE = new False();

    static MyBoolean convertFromPrimitive(boolean b) {
        Map<Boolean, MyBoolean> mapping = new HashMap<>();
        mapping.put(Boolean.TRUE, MyBoolean.TRUE);
        mapping.put(Boolean.FALSE, MyBoolean.FALSE);
        return mapping.get(b);
    }

    MyBoolean ifTrue(Runnable block);

    MyBoolean ifFalse(Runnable block);

    MyBoolean and(MyBoolean other);

    MyBoolean or(MyBoolean other);

    MyBoolean negate();


    class True extends MyObject implements MyBoolean {

        @Override
        public MyBoolean ifTrue(Runnable block) {
            block.run();
            return this;
        }

        @Override
        public MyBoolean ifFalse(Runnable block) {
            return this;
        }

        @Override
        public MyBoolean and(MyBoolean other) {
            return other;
        }

        @Override
        public MyBoolean or(MyBoolean other) {
            return this;
        }

        @Override
        public MyBoolean negate() {
            return FALSE;
        }
    }

    class False extends MyObject implements MyBoolean {

        @Override
        public MyBoolean ifTrue(Runnable block) {
            return this;
        }

        @Override
        public MyBoolean ifFalse(Runnable block) {
            block.run();
            return this;
        }

        @Override
        public MyBoolean and(MyBoolean other) {
            return this;
        }

        @Override
        public MyBoolean or(MyBoolean other) {
            return other;
        }

        @Override
        public MyBoolean negate() {
            return TRUE;
        }
    }
}
