package main.java.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-02.
 */
public class IncompleteTransitionsGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public HashSet<Integer> makeStates() {
        return new HashSet<>(Arrays.asList(0, 1));
    }

    @Override
    public Integer makeStartState() {
        return 0;
    }

    @Override
    public HashSet<Integer> makeAcceptStates() {
        return new HashSet<>();
    }

    @Override
    public Table<Integer, Character, Integer> makeTransitions() {
        Table<Integer, Character, Integer> transitions = HashBasedTable.create();
        transitions.put(0, 'a', 0);
        transitions.put(0, 'b', 1);
        transitions.put(1, 'b', 0);
        return transitions;
    }
}
