package test.java;

import main.java.DFA;
import main.java.exceptions.AcceptStatesNotContainedInStates;
import main.java.exceptions.IncompleteTransitions;
import main.java.exceptions.InvalidTransition;
import main.java.exceptions.StartStateNotInStates;
import main.java.generators.BadAcceptStatesGenerator;
import main.java.generators.EmptyStateSetGenerator;
import main.java.generators.IncompleteTransitionsGenerator;
import main.java.generators.TransitionToInvalidStateGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionsTest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(StartStateNotInStates.class, () -> new DFA(new EmptyStateSetGenerator()));
    }

    @Test
    void badAcceptStates() {
        assertThrows(AcceptStatesNotContainedInStates.class, () -> new DFA(new BadAcceptStatesGenerator()));
    }

    @Test
    void incompleteTransitions() {
        assertThrows(IncompleteTransitions.class, () -> new DFA(new IncompleteTransitionsGenerator()));
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidTransition.class, () -> new DFA(new TransitionToInvalidStateGenerator()));
    }
}
