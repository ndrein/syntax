package org.syntax.generators;

import com.google.common.collect.Table;
import org.syntax.Dfa;
import org.syntax.State;

import java.util.HashSet;


public abstract class DFAGenerator {
    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<State> makeStates();

    protected abstract State makeStartState();

    protected abstract HashSet<State> makeAcceptStates();

    protected abstract Table<State, Character, State> makeTransitions();

    public Dfa generate() {
        return new Dfa(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
    }
}
