package org.syntax.generators;

import com.google.common.collect.Table;
import org.syntax.DFA;
import org.syntax.State;

import java.util.HashSet;


public abstract class DFAGenerator {
    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<State> makeStates();

    protected abstract State makeStartState();

    protected abstract HashSet<State> makeAcceptStates();

    protected abstract Table<State, Character, State> makeTransitions();

    public DFA generate() {
        return new DFA(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
    }
}
