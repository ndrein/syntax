package main.java.instances;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import main.java.State;

import java.util.Collections;
import java.util.HashSet;

public class TrivialInstance extends DFAInstance implements DFAInstanceImplementation {
//    public TrivialInstance() {
//        super(alphabet, states, start_state, accept_states, transitions);
//        super(makeAlphabet(), makeStates(), makeStartState(), makeAcceptStates(), makeTransitions());
//    }

    //    static final private HashSet<Character> alphabet = makeAlphabet();
//    static final private HashSet<State> states = makeStates();
//    static final private State start_state = makeStartState();
//    static final private HashSet<State> accept_states = makeAcceptStates();
//    static final private Table<State, Character, State> transitions = makeTransitions();
//
//    static public HashSet<Character> makeAlphabet() {return null;}
//
//    static public HashSet<State> makeStates() {return null;}
//
//    static public State makeStartState() {return null;}
//
//    static public HashSet<State> makeAcceptStates() {return null;}
//
//    static public Table<State, Character, State> makeTransitions() {return null;}
    static HashSet<Character> makeAlphabet() {
        return new HashSet<>();
    }


    public HashSet<State> makeStates() {
        return new HashSet<State>(Collections.singletonList(new State(0)));
    }


    public State makeStartState() {
        return new State(0);
    }


    public HashSet<State> makeAcceptStates() {
        return new HashSet<State>();
    }


    public Table<State, Character, State> makeTransitions() {
        return HashBasedTable.create();
    }
}
