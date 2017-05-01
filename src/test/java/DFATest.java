package test.java;

import com.google.common.collect.Table;
import main.java.DFA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


abstract class DFATest {
    final private HashSet<Character> alphabet = makeAlphabet();
    final private HashSet<Integer> states = makeStates();
    final private Integer start_state = makeStartState();
    final private HashSet<Integer> accept_states = makeAcceptStates();
    final private Table<Integer, Character, Integer> transitions = makeTransitions();
    final protected DFA dfa = new DFA(alphabet, states, start_state, accept_states, transitions);

    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<Integer> makeStates();

    protected abstract Integer makeStartState();

    protected abstract HashSet<Integer> makeAcceptStates();

    protected abstract Table<Integer, Character, Integer> makeTransitions();

    @Test
    void nullTest() { }
}
