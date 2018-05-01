package org.syntax;

import com.google.common.collect.HashBasedTable;
import org.junit.jupiter.api.Test;
import org.syntax.generators.SimpleGenerator;

import java.util.Collections;
import java.util.HashSet;

class ValidDfaConstructionTest {
    @Test
    void testConstructingTrivialDFA() {
        new Dfa(new HashSet<>(), Collections.singleton(new State(0)), new State(0), new HashSet<>(), HashBasedTable.create());
    }

    @Test
    void testConstructingSimpleDFA() {
        new SimpleGenerator().generate();
    }
}
