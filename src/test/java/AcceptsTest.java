package test.java;

import main.java.DFA;
import main.java.exceptions.InvalidDFAInput;
import main.java.generators.SimpleGenerator;
import main.java.generators.TrivialGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ndrei on 2017-05-02.
 */
class AcceptsTest {
    @Test
    void throwsIfInputNotInAlphabet() {
        DFA dfa = new DFA(new TrivialGenerator());
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(new DFA(new SimpleGenerator()).accepts(Collections.emptyList()));
    }

    @Test
    void acceptsC() {
        assertTrue(new DFA(new SimpleGenerator()).accepts(Arrays.asList('c')));
    }

    @Test
    void acceptsABABCC() {
        assertTrue(new DFA(new SimpleGenerator()).accepts(Arrays.asList('a', 'b', 'a', 'b', 'c', 'c')));
    }

    @Test
    void doesNotAcceptABA() {
        assertFalse(new DFA(new SimpleGenerator()).accepts(Arrays.asList('a', 'b', 'a')));
    }

    @Test
    void acceptsLongInput() {
        List<Character> input = longABs();
        input.add('c');

        assertTrue(new DFA(new SimpleGenerator()).accepts(input));
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
