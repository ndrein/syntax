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
        alphabet = alphabet;
        states = states;
        start_state = start_state;
        accept_states = accept_states;
        transitions = transitions;
    }
}
