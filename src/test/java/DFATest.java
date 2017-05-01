package test.java;

import main.java.DFA;
import org.junit.jupiter.api.Test;


class DFATest {
    private DFA dfa;

    @Test
    void trivialConstruction() {
        new TrivialDFAGenerator().generate();
    }

    @Test
    void simpleConstruction() {
        new SimpleDFAGenerator().generate();
    }

}


