package test.java;

import main.java.HelloWorld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ndrei on 2017-04-27.
 */
class HelloWorldTest {
    private HelloWorld hello;

    @BeforeEach
    void setUp() {
        hello = new HelloWorld();
    }

//    @Test
//    void hello() {
//        assertEquals("hello", hello.hello());
//    }
}