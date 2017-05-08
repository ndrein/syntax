package main.java.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import main.java.State;

import java.util.Collections;
import java.util.HashSet;


public class TrivialGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>();
    }

    @Override
    public HashSet<State> makeStates() {
        return new HashSet<State>(Collections.singletonList(new State(0)));
    }

    @Override
    public State makeStartState() {
        return new State(0);
    }

    @Override
    public HashSet<State> makeAcceptStates() {
        return new HashSet<State>();
    }

    @Override
    public Table<State, Character, State> makeTransitions() {
        return HashBasedTable.create();
    }
}

