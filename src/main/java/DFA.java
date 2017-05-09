package main.java;

import com.google.common.collect.Table;
import main.java.exceptions.InvalidDFAInput;
import main.java.generators.DFAGenerator;

import java.util.HashSet;

public class DFA {
    final private HashSet<Character> alphabet;
    final private HashSet<State> states;
    final private State start_state;
    final private HashSet<State> accept_states;
    final private Table<State, Character, State> transitions;

    public DFA(DFAGenerator dfaGenerator) {
        this(dfaGenerator.makeAlphabet(), dfaGenerator.makeStates(), dfaGenerator.makeStartState(), dfaGenerator.makeAcceptStates(), dfaGenerator.makeTransitions());
    }

    public DFA(HashSet<Character> alphabet, HashSet<State> states, State start_state,
               HashSet<State> accept_states, Table<State, Character, State> transitions) {
        DFAValidator.validate(alphabet, states, start_state, accept_states, transitions);

        this.alphabet = alphabet;
        this.states = states;
        this.start_state = start_state;
        this.accept_states = accept_states;
        this.transitions = transitions;
    }

    public boolean accepts(Iterable<Character> input) {
        return accept_states.contains(traverse(input));
    }

    private State traverse(Iterable<Character> input) {
        State q = start_state;

        for (Character c : input) {
            q = transition(q, c);
        }

        return q;
    }

    private State transition(State q, Character c) {
        State next = transitions.get(q, c);

        if (next == null)
            throw new InvalidDFAInput();

        return next;
    }
}
