package test.java;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-02.
 */
public class EmptyStateSetFactory extends DFAFactory {
    @Override
    protected HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    protected HashSet<Integer> makeStates() {
        return new HashSet<>(Arrays.asList());
    }

    @Override
    protected Integer makeStartState() {
        return 0;
    }

    @Override
    protected HashSet<Integer> makeAcceptStates() {
        return new HashSet<>();
    }

    @Override
    protected Table<Integer, Character, Integer> makeTransitions() {
        return HashBasedTable.create();
    }
}
