package main.java.instances;

import com.google.common.collect.Table;
import main.java.State;

import java.util.HashSet;

public interface DFAInstanceImplementation {
    HashSet<Character> alphabet = makeAlphabet();
    HashSet<State> states = makeStates();
    State start_state = makeStartState();
    HashSet<State> accept_states = makeAcceptStates();
    Table<State, Character, State> transitions = makeTransitions();

    static HashSet<Character> makeAlphabet() {
        return null;
    }

    static HashSet<State> makeStates() {
        return null;
    }

    static State makeStartState() {
        return null;
    }

    static HashSet<State> makeAcceptStates() {
        return null;
    }

    static Table<State, Character, State> makeTransitions() {
        return null;
    }
}
