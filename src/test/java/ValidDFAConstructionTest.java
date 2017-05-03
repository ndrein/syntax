package test.java;

import org.junit.jupiter.api.Test;
import test.java.factories.SimpleGenerator;
import test.java.factories.TrivialGenerator;

/**
 * Created by ndrei on 2017-05-02.
 */
public class ValidDFAConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new TrivialGenerator().generate();
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
