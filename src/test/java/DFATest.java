package test.java;

import main.java.DFA;
import org.junit.jupiter.api.BeforeEach;

/**
 * Created by ndrei on 2017-05-02.
 */
abstract class DFATest {
    final DFAFactory dfaFactory;
    protected DFA dfa;

    protected DFATest(DFAFactory dfaFactory) {
        this.dfaFactory = dfaFactory;
    }

    @BeforeEach
    void setUp() {
        dfa = dfaFactory.generate();
    }
}
