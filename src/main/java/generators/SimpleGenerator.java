package main.java.generators;

import com.google.common.collect.HashBasedTable;
import main.java.State;

import java.util.Arrays;
import java.util.HashSet;

public class SimpleGenerator extends DFAGenerator {
    @Override
    public HashSet<Character> makeAlphabet() {
        return new HashSet<>(Arrays.asList('a', 'b', 'c'));
    }

    @Override
    public HashSet<State> makeStates() {
        return new HashSet<State>(Arrays.asList(new State(0), new State(1), new State(2)));
    }

    @Override
    public State makeStartState() {
        return new State(0);
    }

    @Override
    public HashSet<State> makeAcceptStates() {
        return new HashSet<State>(Arrays.asList(new State(0), new State(2)));
    }

    @Override
    public HashBasedTable<State, Character, State> makeTransitions() {
        HashBasedTable<State, Character, State> transitions = HashBasedTable.create();

        transitions.put(new State(0), 'a', new State(1));
        transitions.put(new State(0), 'b', new State(2));
        transitions.put(new State(0), 'c', new State(2));
        transitions.put(new State(1), 'a', new State(2));
        transitions.put(new State(1), 'b', new State(0));
        transitions.put(new State(1), 'c', new State(2));
        transitions.put(new State(2), 'a', new State(2));
        transitions.put(new State(2), 'b', new State(2));
        transitions.put(new State(2), 'c', new State(2));

        return transitions;
    }
}
