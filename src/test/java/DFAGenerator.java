package test.java;

import com.google.common.collect.HashBasedTable;
import main.java.DFA;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-01.
 */
interface DFAGenerator {
    DFA generate();
}


class TrivialDFAGenerator implements DFAGenerator {
    public DFA generate() {
        return new DFA(new HashSet<>(), new HashSet<>(Collections.singletonList(1)),
                1, new HashSet<>(Arrays.asList()), HashBasedTable.create());
    }
}

class SimpleDFAGenerator implements DFAGenerator {
    public DFA generate() {
        HashSet<Character> alphabet = makeComplexAlphabet();
        HashSet<Integer> states = makeComplexStates();
        Integer start_state = 0;
        HashSet<Integer> accept_states = new HashSet<>(Arrays.asList(0, 2));
        HashBasedTable<Integer, Character, Integer> transitions = makeComplexTransitions();

        return new DFA(alphabet, states, start_state, accept_states, transitions);
    }

    private HashBasedTable<Integer, Character, Integer> makeComplexTransitions() {
        HashBasedTable<Integer, Character, Integer> transitions = HashBasedTable.create();
        transitions.put(0, 'a', 1);
        transitions.put(1, 'c', 0);
        transitions.put(2, 'b', 2);
        return transitions;
    }

    private HashSet<Integer> makeComplexStates() {
        HashSet<Integer> states = new HashSet<>();
        states.add(0);
        states.add(1);
        states.add(2);
        return states;
    }

    private HashSet<Character> makeComplexAlphabet() {
        HashSet<Character> alphabet = new HashSet<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        return alphabet;
    }
}
