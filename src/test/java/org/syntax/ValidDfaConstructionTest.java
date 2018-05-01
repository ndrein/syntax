package org.syntax;

import org.junit.jupiter.api.Test;
import org.syntax.generators.SimpleGenerator;
import org.syntax.generators.TrivialDfa;

class ValidDfaConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new TrivialDfa();
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
