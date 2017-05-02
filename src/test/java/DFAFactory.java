package test.java;

import com.google.common.collect.Table;
import main.java.DFA;
import main.java.InvalidDFAConstructionException;

import java.util.HashSet;


abstract class DFAFactory {
    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<Integer> makeStates();

    protected abstract Integer makeStartState();

    protected abstract HashSet<Integer> makeAcceptStates();

    protected abstract Table<Integer, Character, Integer> makeTransitions();

    public DFA generate() throws InvalidDFAConstructionException {
        return new DFA(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
    }
}
