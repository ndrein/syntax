package org.syntax;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;
import org.syntax.exceptions.AcceptStatesNotContainedInStates;
import org.syntax.exceptions.IncompleteTransitions;
import org.syntax.exceptions.InvalidTransition;
import org.syntax.exceptions.StartStateNotInStates;
import org.syntax.generators.TransitionToInvalidStateGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidDfaConstructionsTest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStates.class,
                () -> new Dfa(Sets.newHashSet('a', 'b'), Sets.newHashSet(), new State(0), new HashSet<>(), HashBasedTable.create()));
    }

    @Test
    void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStates.class,
                () -> new Dfa(Sets.newHashSet('a', 'b'), Sets.newHashSet(new State(0), new State(1), new State(2)),
                        new State(0), Sets.newHashSet(new State(0), new State(3)), HashBasedTable.create()));
    }

    @Test
    void incompleteTransitions() {
        Set<Character> alphabet = Sets.newHashSet('a', 'b');
        State startState = new State(0);
        Set<State> states = Sets.newHashSet(startState, new State(1));
        Set<State> acceptStates = Collections.emptySet();
        Table<State, Character, State> transitions = HashBasedTable.create();
        transitions.put(new State(0), 'a', new State(0));
        transitions.put(new State(0), 'b', new State(1));
        transitions.put(new State(1), 'b', new State(0));

        assertThrows(IncompleteTransitions.class, () -> new Dfa(alphabet, states, startState, acceptStates, transitions));
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidTransition.class, () -> new TransitionToInvalidStateGenerator().generate());
    }
}
