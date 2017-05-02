package test.java;

import main.java.InvalidDFAConstructionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
public class EmptyStateSetDFATest extends DFATest {
    @Test
    void cantConstructWithEmptyStateSet() {
        assertThrows(InvalidDFAConstructionException.class, () -> {
            new EmptyStateSetDFAFactory().generate();
        });
    }
}
