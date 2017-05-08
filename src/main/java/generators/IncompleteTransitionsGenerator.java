package main.java.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import main.java.State;

import java.util.Arrays;
import java.util.HashSet;

public class IncompleteTransitionsGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b'));
    }

    @Override
    public HashSet<State> makeStates() {
        return new HashSet<State>(Arrays.asList(new State(0), new State(1)));
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
        Table<State, Character, State> transitions = HashBasedTable.create();
        transitions.put(new State(0), 'a', new State(0));
        transitions.put(new State(0), 'b', new State(1));
        transitions.put(new State(1), 'b', new State(0));
        return transitions;
    }
}
