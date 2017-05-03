package test.java;

import main.java.exceptions.AcceptStatesNotContainedInStates;
import main.java.exceptions.IncompleteTransitions;
import main.java.exceptions.InvalidTransition;
import main.java.exceptions.StartStateNotInStates;
import org.junit.jupiter.api.Test;
import test.java.generators.BadAcceptStatesGenerator;
import test.java.generators.EmptyStateSetGenerator;
import test.java.generators.IncompleteTransitionsGenerator;
import test.java.generators.TransitionToInvalidStateGenerator;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionsTest {
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
