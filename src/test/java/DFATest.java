package test.java;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import main.java.DFA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ndrei on 2017-04-27.
 */
class DFATest {
    public DFA dfa;

    @Test
    void mostBasicConstruction() {
        dfa = new DFA(new HashSet<Character>(), new HashSet<>(Arrays.asList(1)),
                1, new HashSet<>(Arrays.asList(1, 2)), HashBasedTable.create());
    }
}