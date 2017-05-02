package main.java;

import com.google.common.collect.Table;

import java.util.HashSet;

/**
 * Created by ndrei on 2017-04-27.
 */
public class DFA {
    private HashSet<Character> alphabet;
    private HashSet<Integer> states;
    private Integer start_state;
    private HashSet<Integer> accept_states;
    private Table<Integer, Character, Integer> transitions;

    public DFA(HashSet<Character> alphabet, HashSet<Integer> states, Integer start_state,
               HashSet<Integer> accept_states, Table<Integer, Character, Integer> transitions) {
        this.alphabet = alphabet;
        this.states = states;
        this.start_state = start_state;
        this.accept_states = accept_states;
        this.transitions = transitions;

        validateConstruction();
    }

    private void validateConstruction() {
        checkStartState();
        checkAcceptStates();
        checkTransitions();
    }

    private void checkStartState() {
        if (!states.contains(start_state))
            throw new InvalidDFAConstructionException("Start state not in state set");
    }

    private void checkAcceptStates() {
        if (!states.containsAll(accept_states))
            throw new InvalidDFAConstructionException("Accept states not contained in state set");
    }

    private void checkTransitions() {
        for (Integer q : states) {
            for (Character c : alphabet) {
                checkTransition(q, c);
            }
        }
    }

    private void checkTransition(Integer q, Character c) {
        checkTransitionDefined(q, c);
        checkTransitionValid(q, c);
    }

    private void checkTransitionDefined(Integer q, Character c) {
        if (!transitions.contains(q, c))
            throw new InvalidDFAConstructionException(String.format("No transition defined for %d x %s", q, c));
    }

    private void checkTransitionValid(Integer q, Character c) {
        Integer next = transitions.get(q, c);
        if (!states.contains(next))
            throw new InvalidDFAConstructionException(String.format("Transition %d x %c -> %d is invalid", q, c, next));
    }
}
