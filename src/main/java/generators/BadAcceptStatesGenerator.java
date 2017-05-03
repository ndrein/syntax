package main.java.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-02.
 */
public class BadAcceptStatesGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public Integer makeStartState() {
        return 0;
    }

    @Override
    public HashSet<Integer> makeStates() {
        return new HashSet<>(Arrays.asList(0, 1, 2));
    }

    @Override
    public HashSet<Integer> makeAcceptStates() {
        return new HashSet<>(Arrays.asList(0, 3));
    }

    @Override
    public Table<Integer, Character, Integer> makeTransitions() {
        return HashBasedTable.create();
    }
}
