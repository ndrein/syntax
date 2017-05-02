package test.java;

import org.junit.jupiter.api.Test;

/**
 * Created by ndrei on 2017-05-02.
 */
class SimpleDFATest extends DFATest {
    SimpleDFATest() {
        super(new SimpleDFAFactory());
    }

    @Test
    void emptyTest() {

    }
}
