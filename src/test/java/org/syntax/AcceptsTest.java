package org.syntax;

import com.google.common.collect.HashBasedTable;
import org.junit.jupiter.api.Test;
import org.syntax.exceptions.InvalidDFAInput;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class AcceptsTest {
    @Test
    void throwsIfInputNotInAlphabet() {
        Dfa dfa = new Dfa(new HashSet<>(), Collections.singleton(new State(0)), new State(0), new HashSet<>(), HashBasedTable.create());
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(new SimpleDfa().accepts(Collections.emptyList()));
    }

    @Test
    void acceptsC() {
        assertTrue(new SimpleDfa().accepts(Collections.singletonList('c')));
    }

    @Test
    void acceptsABABCC() {
        assertTrue(new SimpleDfa().accepts(Arrays.asList('a', 'b', 'a', 'b', 'c', 'c')));
    }

    @Test
    void doesNotAcceptABA() {
        assertFalse(new SimpleDfa().accepts(Arrays.asList('a', 'b', 'a')));
    }

    @Test
    void acceptsLongInput() {
        List<Character> input = longABs();
        input.add('c');

        assertTrue(new SimpleDfa().accepts(input));
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
