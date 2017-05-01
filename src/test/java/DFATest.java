package test.java;

import main.java.DFA;
import org.junit.jupiter.api.Test;


class DFATest {
    private DFA dfa;

    @Test
    void basicConstruction() {
        new TrivialDFAGenerator().generate();
    }

    @Test
    void complexConstruction() {
        new SimpleDFAGenerator().generate();
    }
}


