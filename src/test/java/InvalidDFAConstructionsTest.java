package test.java;

import main.java.InvalidDFAConstructionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionsTest extends DFATest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(InvalidDFAConstructionException.class, () -> {
            new EmptyStateSetFactory().generate();
        });
    }

    @Test
    void badAcceptStates() {
        assertThrows(InvalidDFAConstructionException.class, () -> {
            new BadAcceptStatesFactory().generate();
        });
    }

    @Test
    void incompleteTransitions() {
        assertThrows(InvalidDFAConstructionException.class, () -> {
            new IncompleteTransitionsFactory().generate();
        });
    }

    @Test
    void transitionToInvalidState() {
        assertThrows(InvalidDFAConstructionException.class, () -> {
            new TransitionToInvalidStateFactory().generate();
        });
    }
}
