package test.java;

import org.junit.jupiter.api.Test;
import test.java.factories.SimpleFactory;
import test.java.factories.TrivialFactory;

/**
 * Created by ndrei on 2017-05-02.
 */
public class ValidDFAConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new TrivialFactory().generate();
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleFactory().generate();
    }
}
