package main.java.generators;

import com.google.common.collect.Table;
import main.java.State;

import java.util.HashSet;


public abstract class DFAGenerator {
    // Subclasses of the DFAGenerator can generate specific DFA instances
    // These specific instances are for use in testing

    public abstract HashSet<Character> makeAlphabet();

    public abstract HashSet<State> makeStates();

    public abstract State makeStartState();

    public abstract HashSet<State> makeAcceptStates();

    public abstract Table<State, Character, State> makeTransitions();
}
