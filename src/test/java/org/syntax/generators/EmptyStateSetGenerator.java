package org.syntax.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.syntax.State;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class EmptyStateSetGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public HashSet<State> makeStates() {
        return new HashSet<>(Collections.emptyList());
    }

    @Override
    public State makeStartState() {
        return new State(0);
    }

    @Override
    public HashSet<State> makeAcceptStates() {
        return new HashSet<>();
    }

    @Override
    public Table<State, Character, State> makeTransitions() {
        return HashBasedTable.create();
    }
}
