package main.java;

import com.google.common.collect.Table;
import main.java.exceptions.*;

import java.util.HashSet;

/**
 * Created by ndrei on 2017-05-02.
 */
class DFAValidator {
    static void validate(HashSet<Character> alphabet,
                         HashSet<Integer> states, Integer start_state, HashSet<Integer> accept_states,
                         Table<Integer, Character, Integer> transitions) throws InvalidDFAConstruction {
        checkStartState(start_state, states);
        checkAcceptStates(accept_states, states);
        checkTransitions(transitions, states, alphabet);
    }

    private static void checkStartState(Integer start_state, HashSet<Integer> states) {
        if (!states.contains(start_state))
            throw new StartStateNotInStates();
    }

    private static void checkAcceptStates(HashSet<Integer> accept_states, HashSet<Integer> states) {
        if (!states.containsAll(accept_states))
            throw new AcceptStatesNotContainedInStates();
    }

    private static void checkTransitions(Table<Integer, Character, Integer> transitions,
                                         HashSet<Integer> states, HashSet<Character> alphabet) {
        for (Integer q : states) {
            for (Character c : alphabet) {
                checkTransition(q, c, transitions, states);
            }
        }
    }

    private static void checkTransition(Integer q, Character c,
                                        Table<Integer, Character, Integer> transitions,
                                        HashSet<Integer> states) {
        checkTransitionDefined(q, c, transitions);
        checkTransitionValid(q, c, transitions, states);
    }

    private static void checkTransitionDefined(Integer q, Character c,
                                               Table<Integer, Character, Integer> transitions) {
        if (!transitions.contains(q, c))
            throw new IncompleteTransitions(String.format("No transition defined for %d x %s", q, c));
    }

    private static void checkTransitionValid(Integer q, Character c,
                                             Table<Integer, Character, Integer> transitions,
                                             HashSet<Integer> states) {
        Integer next = transitions.get(q, c);
        if (!states.contains(next))
            throw new InvalidTransition(String.format("Transition %d x %c -> %d is invalid", q, c, next));
    }
}
