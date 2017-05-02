package test.java;

import com.google.common.collect.Table;
import main.java.DFA;
import main.java.exceptions.InvalidDFAConstruction;

import java.util.HashSet;


abstract class DFAFactory {
    // Subclasses of the DFAFactory can generate specific DFA instances
    // These specific instances are for use in testing

    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<Integer> makeStates();

    protected abstract Integer makeStartState();

    protected abstract HashSet<Integer> makeAcceptStates();

    protected abstract Table<Integer, Character, Integer> makeTransitions();

    public DFA generate() throws InvalidDFAConstruction {
        return new DFA(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
    }
}
