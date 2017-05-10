package main.java.generators;

import com.google.common.collect.Table;
import main.java.DFA;
import main.java.State;

import java.util.HashSet;


public abstract class DFAGenerator {
    public abstract HashSet<Character> makeAlphabet();

    public abstract HashSet<State> makeStates();

    public abstract State makeStartState();

    public abstract HashSet<State> makeAcceptStates();

    public abstract Table<State, Character, State> makeTransitions();

    public DFA generate() {
        return new DFA(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
    }
}
