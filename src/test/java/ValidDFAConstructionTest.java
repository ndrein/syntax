package test.java;

import main.java.generators.SimpleGenerator;
import main.java.generators.TrivialGenerator;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class ValidDFAConstructionTest {
    @Test
    public void testConstructingTrivialDFA() {
        new TrivialGenerator().generate();
//        new TrivialInstance();
    }

    @Test
    public void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
