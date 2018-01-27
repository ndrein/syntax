package test.java;

import main.java.DFA;
import main.java.exceptions.InvalidDFAInput;
import main.java.generators.SimpleGenerator;
import main.java.generators.TrivialGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptsTest {
    @Test
    public void throwsIfInputNotInAlphabet() {
        DFA dfa = new TrivialGenerator().generate();
        assertThrows(InvalidDFAInput.class, () -> dfa.accepts(Collections.singletonList('a')));
    }

    @Test
    public void acceptsEmptyString() {
        assertTrue(new SimpleGenerator().generate().accepts(Collections.emptyList()));
    }

    @Test
    public void acceptsC() {
        assertTrue(new SimpleGenerator().generate().accepts(Arrays.asList('c')));
    }

    @Test
    public void acceptsABABCC() {
        assertTrue(new SimpleGenerator().generate().accepts(Arrays.asList('a', 'b', 'a', 'b', 'c', 'c')));
    }

    @Test
    public void doesNotAcceptABA() {
        assertFalse(new SimpleGenerator().generate().accepts(Arrays.asList('a', 'b', 'a')));
    }

    @Test
    public void acceptsLongInput() {
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
