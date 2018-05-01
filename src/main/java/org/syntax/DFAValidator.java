package org.syntax;

import com.google.common.collect.Table;
import org.syntax.exceptions.*;

import java.util.Set;

class DFAValidator {
    static void validate(Set<Character> alphabet, Set<State> states,
                         State start_state, Set<State> accept_states,
                         Table<State, Character, State> transitions) throws InvalidDFAConstruction {
        checkStartState(start_state, states);
        checkAcceptStates(accept_states, states);
        checkTransitions(transitions, states, alphabet);
    }

    private static void checkStartState(State start_state, Set<State> states) {
        if (!states.contains(start_state))
            throw new StartStateNotInStates();
    }

    private static void checkAcceptStates(Set<State> accept_states, Set<State> states) {
        if (!states.containsAll(accept_states))
            throw new AcceptStatesNotContainedInStates();
    }

    private static void checkTransitions(Table<State, Character, State> transitions,
                                         Set<State> states, Set<Character> alphabet) {
        for (State q : states) {
            for (Character c : alphabet) {
                checkTransition(q, c, transitions, states);
            }
        }
    }

    private static void checkTransition(State q, Character c,
                                        Table<State, Character, State> transitions,
                                        Set<State> states) {
        checkTransitionDefined(q, c, transitions);
        checkTransitionValid(q, c, transitions, states);
    }

    private static void checkTransitionDefined(State q, Character c,
                                               Table<State, Character, State> transitions) {
        if (!transitions.contains(q, c))
            throw new IncompleteTransitions(
                    String.format("No transition defined for %d x %s", q.getInt(), c));
    }

    private static void checkTransitionValid(State q, Character c,
                                             Table<State, Character, State> transitions,
                                             Set<State> states) {
        State next = transitions.get(q, c);
        if (!states.contains(next))
            throw new InvalidTransition(String.format("Transition %d x %c -> %d is invalid", q.getInt(), c, next.getInt()));
    }
}
