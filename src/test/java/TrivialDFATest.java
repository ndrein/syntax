package test.java;

import main.java.exceptions.InvalidDFAInput;
import org.junit.jupiter.api.Test;
import test.java.factories.TrivialFactory;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by ndrei on 2017-05-02.
 */
class TrivialDFATest extends DFATest {
    @Test
    void testConstructor() {
        new TrivialFactory().generate();
    }

    @Test
    void aNotInAlphabet() {
        dfa = new TrivialFactory().generate();
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }
}
