package main.java;

import com.google.common.collect.Table;
import main.java.exceptions.*;

import java.util.HashSet;

class DFAValidator {
    static void validate(HashSet<Character> alphabet,
                         HashSet<State> states, State start_state, HashSet<State> accept_states,
                         Table<State, Character, State> transitions) throws InvalidDFAConstruction {
        checkStartState(start_state, states);
        checkAcceptStates(accept_states, states);
        checkTransitions(transitions, states, alphabet);
    }

    private static void checkStartState(State start_state, HashSet<State> states) {
        if (!states.contains(start_state))
            throw new StartStateNotInStates();
    }

    private static void checkAcceptStates(HashSet<State> accept_states, HashSet<State> states) {
        if (!states.containsAll(accept_states))
            throw new AcceptStatesNotContainedInStates();
    }

    private static void checkTransitions(Table<State, Character, State> transitions,
                                         HashSet<State> states, HashSet<Character> alphabet) {
        for (State q : states) {
            for (Character c : alphabet) {
                checkTransition(q, c, transitions, states);
            }
        }
    }

    private static void checkTransition(State q, Character c,
                                        Table<State, Character, State> transitions,
                                        HashSet<State> states) {
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
                                             HashSet<State> states) {
        State next = transitions.get(q, c);
        if (!states.contains(next))
            throw new InvalidTransition(String.format("Transition %d x %c -> %d is invalid", q.getInt(), c, next.getInt()));
    }
}
