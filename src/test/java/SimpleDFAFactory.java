package test.java;

import com.google.common.collect.HashBasedTable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-01.
 */
class SimpleDFAFactory extends DFAFactory {
    @Override
    protected HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b', 'c'));
    }

    @Override
    protected HashSet<Integer> makeStates() {
        return new HashSet<>(Arrays.asList(0, 1, 2));
    }

    @Override
    protected Integer makeStartState() {
        return 0;
    }

    @Override
    protected HashSet<Integer> makeAcceptStates() {
        return new HashSet<>(Arrays.asList(0, 2));
    }

    @Override
    protected HashBasedTable<Integer, Character, Integer> makeTransitions() {
        HashBasedTable<Integer, Character, Integer> transitions = HashBasedTable.create();
        transitions.put(0, 'a', 1);
        transitions.put(1, 'c', 0);
        transitions.put(2, 'b', 2);
        return transitions;
    }
}
