package test.java;

import main.java.DFA;
import main.java.generators.SimpleGenerator;
import main.java.generators.TrivialGenerator;
import org.junit.jupiter.api.Test;

public class ValidDFAConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new DFA(new TrivialGenerator());
    }

    @Test
    void testConstructingSimpleDFA() {
        new DFA(new SimpleGenerator());
    }
}
