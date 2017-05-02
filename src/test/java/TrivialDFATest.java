package test.java;

import org.junit.jupiter.api.Test;

/**
 * Created by ndrei on 2017-05-02.
 */
class TrivialDFATest extends DFATest {
    protected TrivialDFATest() {
        super(new SimpleDFAFactory());
    }

    @Test
    void emptyTest() {
        // Test set up method
    }
}
