package org.syntax;

import org.junit.jupiter.api.Test;
import org.syntax.exceptions.InvalidDFAInput;
import org.syntax.generators.SimpleGenerator;
import org.syntax.generators.TrivialGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AcceptsTest {
    @Test
    void throwsIfInputNotInAlphabet() {
        Dfa dfa = new TrivialGenerator().generate();
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(new SimpleGenerator().generate().accepts(Collections.emptyList()));
    }

    @Test
    void acceptsC() {
        assertTrue(new SimpleGenerator().generate().accepts(Collections.singletonList('c')));
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

    private List<Character> longABs() {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < 1000; ++i) {
            list.add('a');
            list.add('b');
        }
        return list;
    }
}
