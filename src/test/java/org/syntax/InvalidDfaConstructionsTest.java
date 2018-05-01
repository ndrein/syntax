package org.syntax;

import org.junit.jupiter.api.Test;
import org.syntax.exceptions.AcceptStatesNotContainedInStates;
import org.syntax.exceptions.IncompleteTransitions;
import org.syntax.exceptions.InvalidTransition;
import org.syntax.exceptions.StartStateNotInStates;
import org.syntax.generators.BadAcceptStatesGenerator;
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
        assertThrows(AcceptStatesNotContainedInStates.class, () -> new BadAcceptStatesGenerator().generate());
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
