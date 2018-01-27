package test.java;

import main.java.exceptions.AcceptStatesNotContainedInStates;
import main.java.exceptions.IncompleteTransitions;
import main.java.exceptions.InvalidTransition;
import main.java.exceptions.StartStateNotInStates;
import main.java.generators.BadAcceptStatesGenerator;
import main.java.generators.EmptyStateSetGenerator;
import main.java.generators.IncompleteTransitionsGenerator;
import main.java.generators.TransitionToInvalidStateGenerator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//import org.junit.jupiter.api.Test;

public class InvalidDFAConstructionsTest {
    @Test
    public void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStates.class, () -> new EmptyStateSetGenerator().generate());
    }

    @Test
    public void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStates.class, () -> new BadAcceptStatesGenerator().generate());
    }

    @Test
    public void incompleteTransitions() {
        assertThrows(IncompleteTransitions.class, () -> new IncompleteTransitionsGenerator().generate());
    }

    @Test
    public void transitionToInvalidState() {
        assertThrows(InvalidTransition.class, () -> new TransitionToInvalidStateGenerator().generate());
    }
}
