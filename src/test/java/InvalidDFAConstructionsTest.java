package test.java;

import main.java.AcceptStatesNotContainedInStatesException;
import main.java.IncompleteTransitionsException;
import main.java.InvalidTransitionException;
import main.java.StartStateNotInStatesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionsTest extends DFATest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStatesException.class, () -> {
            new EmptyStateSetFactory().generate();
        });
    }

    @Test
    void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStatesException.class, () -> {
            new BadAcceptStatesFactory().generate();
        });
    }

    @Test
    void incompleteTransitions() {
        assertThrows(IncompleteTransitionsException.class, () -> {
            new IncompleteTransitionsFactory().generate();
        });
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidTransitionException.class, () -> {
            new TransitionToInvalidStateFactory().generate();
        });
    }
}
