package test.java;

import main.java.exceptions.InvalidDFAInput;
import org.junit.jupiter.api.Test;
import test.java.generators.SimpleGenerator;
import test.java.generators.TrivialGenerator;

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
        dfa = new TrivialGenerator().generate();
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(new SimpleGenerator().generate().accepts(Collections.emptyList()));
    }

    @Test
    void acceptsC() {
        assertTrue(new SimpleGenerator().generate().accepts(Arrays.asList('c')));
    }

    @Test
    void acceptsABABCC() {
        assertTrue(new SimpleGenerator().generate().accepts(Arrays.asList('a', 'b', 'a', 'b', 'c', 'c')));
    }

    @Test
    void doesNotAcceptABA() {
        assertFalse(new SimpleGenerator().generate().accepts(Arrays.asList('a', 'b', 'a')));
    }

    @Test
    void acceptsLongInput() {
        List<Character> input = longABs();
        input.add('c');

        assertTrue(new SimpleGenerator().generate().accepts(input));
    }

    List<Character> longABs() {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < 1000; ++i) {
            list.add('a');
            list.add('b');
        }
        return list;
    }
}
