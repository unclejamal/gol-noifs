package testframework;

import com.pduda.myjava.MyBoolean;
import com.pduda.myjava.MyObject;

public class Assertions {
    public static void assertEquals(MyObject expected, MyObject actual) {
        expected.myEquals(actual)
                .ifFalse(() -> {
                    String message = String.format("%nExpected %s%n but was %s", expected, actual);
                    throw new AssertionFailedException(message);
                });
    }

    public static void assertNotEquals(MyObject expected, MyObject actual) {
        expected.myEquals(actual)
                .ifTrue(() -> {
                    String message = String.format("%nExpected something else than %s%n but was %s", expected, actual);
                    throw new AssertionFailedException(message);
                });
    }

    public static void assertFalse(MyBoolean actual) {
        actual
                .ifTrue(() -> {
                    String message = String.format("%nExpected a false value");
                    throw new AssertionFailedException(message);
                });
    }

    public static void assertTrue(MyBoolean actual) {
        actual
                .ifFalse(() -> {
                    String message = String.format("%nExpected a true value");
                    throw new AssertionFailedException(message);
                });
    }
}
