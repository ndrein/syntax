package main.java;

import com.google.common.collect.Table;

import java.util.HashSet;
import java.util.List;

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
        DFAValidator.validate(alphabet, states, start_state, accept_states, transitions);

        this.alphabet = alphabet;
        this.states = states;
        this.start_state = start_state;
        this.accept_states = accept_states;
        this.transitions = transitions;
    }

    public boolean accepts(List<Character> input) {
        return accept_states.contains(traverse(input));
    }

    private Integer traverse(List<Character> input) {
        Integer q = start_state;

        for (Character c : input) {
            q = transition(q, c);
        }

        return q;
    }

    private Integer transition(Integer q, Character c) {
        Integer next = transitions.get(q, c);

        if (next == null)
            throw new InvalidDFAInput();

        return next;
    }
}
