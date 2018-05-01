package org.syntax;

import com.google.common.collect.Table;
import org.syntax.exceptions.InvalidDFAInput;

import java.util.Set;

public class Dfa {
    final private State start_state;
    final private Set<State> accept_states;
    final private Table<State, Character, State> transitions;

    public Dfa(Set<Character> alphabet, Set<State> states, State start_state, Set<State> accept_states, Table<State, Character, State> transitions) {
        DFAValidator.validate(alphabet, states, start_state, accept_states, transitions);

        this.start_state = start_state;
        this.accept_states = accept_states;
        this.transitions = transitions;
    }

    boolean accepts(Iterable<Character> input) {
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
