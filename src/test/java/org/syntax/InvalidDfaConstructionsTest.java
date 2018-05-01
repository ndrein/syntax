package org.syntax;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.syntax.exceptions.AcceptStatesNotContainedInStates;
import org.syntax.exceptions.IncompleteTransitions;
import org.syntax.exceptions.InvalidTransition;
import org.syntax.exceptions.StartStateNotInStates;
import org.syntax.generators.EmptyStateSetGenerator;
import org.syntax.generators.IncompleteTransitionsGenerator;
import org.syntax.generators.TransitionToInvalidStateGenerator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidDfaConstructionsTest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStates.class, () -> new EmptyStateSetGenerator().generate());
    }

    @Test
    void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStates.class, () -> new Dfa(Sets.newHashSet('a', 'b'), Sets.newHashSet(new State(0), new State(1), new State(2)), new State(0),
                Sets.newHashSet(new State(0), new State(3)), HashBasedTable.create()));
    }

    @Test
    void incompleteTransitions() {
        assertThrows(IncompleteTransitions.class, () -> new IncompleteTransitionsGenerator().generate());
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidTransition.class, () -> new TransitionToInvalidStateGenerator().generate());
    }
}
