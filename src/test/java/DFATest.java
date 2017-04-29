package test.java;

import com.google.common.collect.HashBasedTable;
import main.java.DFA;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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

    @Test
    void complexConstruction() {
        HashSet<Character> alphabet = new HashSet<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');

        HashSet<Integer> states = new HashSet<>();
        states.add(0);
        states.add(1);
        states.add(2);

        Integer start_state = 0;

        HashSet<Integer> accept_states = new HashSet<>();

        HashBasedTable<Integer, Character, Integer> transitions = HashBasedTable.create();
        transitions.put(0, 'a', 1);
        transitions.put(1, 'c', 0);
        transitions.put(2, 'b', 2);

        dfa = new DFA(alphabet, states, start_state, accept_states, transitions);
    }
}