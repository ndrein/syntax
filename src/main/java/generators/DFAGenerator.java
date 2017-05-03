package main.java.generators;

import com.google.common.collect.Table;

import java.util.HashSet;


public abstract class DFAGenerator {
    // Subclasses of the DFAGenerator can generate specific DFA instances
    // These specific instances are for use in testing

    public abstract HashSet<Character> makeAlphabet();

    public abstract HashSet<Integer> makeStates();

    public abstract Integer makeStartState();

    public abstract HashSet<Integer> makeAcceptStates();

    public abstract Table<Integer, Character, Integer> makeTransitions();
}
