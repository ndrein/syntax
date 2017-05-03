package test.java;

import main.java.exceptions.InvalidDFAInput;
import org.junit.jupiter.api.Test;
import test.java.factories.SimpleFactory;
import test.java.factories.TrivialFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ndrei on 2017-05-02.
 */
class AcceptsTest extends DFATest {
    @Test
    void throwsIfInputNotInAlphabet() {
        dfa = new TrivialFactory().generate();
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(new SimpleFactory().generate().accepts(Collections.emptyList()));
    }

    @Test
    void acceptsC() {
        assertTrue(new SimpleFactory().generate().accepts(Arrays.asList('c')));
    }

    @Test
    void acceptsABABCC() {
        assertTrue(new SimpleFactory().generate().accepts(Arrays.asList('a', 'b', 'a', 'b', 'c', 'c')));
    }

    @Test
    void doesNotAcceptABA() {
        assertFalse(new SimpleFactory().generate().accepts(Arrays.asList('a', 'b', 'a')));
    }

    @Test
    void acceptsLongInput() {
        List<Character> input = new LinkedList<Character>();
        for (int i = 0; i < 1000; ++i) {
            input.add('a');
            input.add('b');
        }
        input.add('c');

        assertTrue(new SimpleFactory().generate().accepts(input));
    }
}
