package org.syntax;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

import java.util.Set;

class SimpleDfa extends Dfa {
    private static final Set<Character> alphabet;
    private static final State startState;
    private static final Set<State> states;
    private static final Set<State> acceptStates;
    private static final Table<State, Character, State> transitions;

    static {
        alphabet = Sets.newHashSet('a', 'b', 'c');
        startState = new State(0);
        states = Sets.newHashSet(startState, new State(1), new State(2));
        acceptStates = Sets.newHashSet(startState, new State(2));
        transitions = HashBasedTable.create();
        transitions.put(new State(0), 'a', new State(1));
        transitions.put(new State(0), 'b', new State(2));
        transitions.put(new State(0), 'c', new State(2));
        transitions.put(new State(1), 'a', new State(2));
        transitions.put(new State(1), 'b', new State(0));
        transitions.put(new State(1), 'c', new State(2));
        transitions.put(new State(2), 'a', new State(2));
        transitions.put(new State(2), 'b', new State(2));
        transitions.put(new State(2), 'c', new State(2));
    }

    SimpleDfa() {
        super(alphabet, states, startState, acceptStates, transitions);
    }
}
