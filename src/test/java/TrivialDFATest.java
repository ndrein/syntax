package test.java;

import org.junit.jupiter.api.Test;

/**
 * Created by ndrei on 2017-05-02.
 */
class TrivialDFATest extends DFATest {
    @Test
    void testConstructor() {
        new TrivialDFAFactory().generate();
    }
}
