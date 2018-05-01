package org.syntax.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.syntax.State;

import java.util.Arrays;
import java.util.HashSet;

public class BadAcceptStatesGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public State makeStartState() {
        return new State(0);
    }

    @Override
    public HashSet<State> makeStates() {
        return new HashSet<State>(Arrays.asList(new State(0), new State(1), new State(2)));
    }

    @Override
    public HashSet<State> makeAcceptStates() {
        return new HashSet<State>(Arrays.asList(new State(0), new State(3)));
    }

    @Override
    public Table<State, Character, State> makeTransitions() {
        return HashBasedTable.create();
    }
}
