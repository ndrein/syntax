package test.java;

import main.java.DFA;
import main.java.generators.SimpleGenerator;
import main.java.generators.TrivialGenerator;
import org.junit.jupiter.api.Test;

public class ValidDFAConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new TrivialGenerator().generate();
//        new TrivialInstance();
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
