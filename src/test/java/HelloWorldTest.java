package test.java;

import main.java.HelloWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ndrei on 2017-04-27.
 */
class HelloWorldTest {
    @Test
    void hello() {
        HelloWorld hello = new HelloWorld();
        assertEquals("hello", hello.hello());
    }
}