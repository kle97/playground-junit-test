package io.playground.junittest.common;

import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private final String toString = System.nanoTime() + "@" + getClass().getName();

    @Override
    public String toString() {
        return toString;
    }

    protected SoftAssertJ softly() {
        return SoftAssertJ.getInstance();
    }
}
