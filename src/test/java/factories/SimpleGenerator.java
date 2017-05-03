package test.java.factories;

import com.google.common.collect.HashBasedTable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-01.
 */
public class SimpleGenerator extends DFAGenerator {
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
        transitions.put(0, 'b', 2);
        transitions.put(0, 'c', 2);
        transitions.put(1, 'a', 2);
        transitions.put(1, 'b', 0);
        transitions.put(1, 'c', 2);
        transitions.put(2, 'a', 2);
        transitions.put(2, 'b', 2);
        transitions.put(2, 'c', 2);

        return transitions;
    }
}
