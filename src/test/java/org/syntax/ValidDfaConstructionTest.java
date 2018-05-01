package org.syntax;

import org.junit.jupiter.api.Test;
import org.syntax.generators.SimpleGenerator;
import org.syntax.generators.TrivialGenerator;

class ValidDfaConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new TrivialGenerator().generate();
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
