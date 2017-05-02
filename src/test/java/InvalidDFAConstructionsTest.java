package test.java;

import main.java.exceptions.AcceptStatesNotContainedInStates;
import main.java.exceptions.IncompleteTransitions;
import main.java.exceptions.InvalidTransition;
import main.java.exceptions.StartStateNotInStates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionsTest extends DFATest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStates.class, () -> new EmptyStateSetFactory().generate());
    }

    @Test
    void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStates.class, () -> new BadAcceptStatesFactory().generate());
    }

    @Test
    void incompleteTransitions() {
        assertThrows(IncompleteTransitions.class, () -> new IncompleteTransitionsFactory().generate());
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidTransition.class, () -> new TransitionToInvalidStateFactory().generate());
    }
}
