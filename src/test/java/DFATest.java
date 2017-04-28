package test.java;

import com.google.common.collect.HashBasedTable;
import main.java.DFA;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


class DFATest {
    private DFA dfa;

    @Test
    void basicConstruction() {
        dfa = new DFA(new HashSet<>(), new HashSet<>(Collections.singletonList(1)),
                1, new HashSet<>(Arrays.asList(1, 2)), HashBasedTable.create());
    }
}