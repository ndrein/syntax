package main.java.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-02.
 */
public class EmptyStateSetGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public HashSet<Integer> makeStates() {
        return new HashSet<>(Collections.emptyList());
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
        return HashBasedTable.create();
    }
}
