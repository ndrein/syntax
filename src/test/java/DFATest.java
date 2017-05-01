package test.java;

import com.google.common.collect.Table;
import main.java.DFA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


abstract class DFATest {
    final protected HashSet<Character> alphabet = makeAlphabet();
    final protected HashSet<Integer> states = makeStates();
    final protected Integer start_state = makeStartState();
    final protected HashSet<Integer> accept_states = makeAcceptStates();
    final protected Table<Integer, Character, Integer> transitions = makeTransitions();
    final protected DFA dfa = new DFA(alphabet, states, start_state, accept_states, transitions);

    protected abstract HashSet<Character> makeAlphabet();

    protected abstract HashSet<Integer> makeStates();

    protected abstract Integer makeStartState();

    protected abstract HashSet<Integer> makeAcceptStates();

    protected abstract Table<Integer, Character, Integer> makeTransitions();

    @Test
    void testConstructor() {
        // Implicitly tests the constructor
    }
}



