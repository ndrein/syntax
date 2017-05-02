package test.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by ndrei on 2017-05-02.
 */
class SimpleDFATest extends DFATest {
    @Test
    void testConstructor() {
        new SimpleFactory().generate();
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
