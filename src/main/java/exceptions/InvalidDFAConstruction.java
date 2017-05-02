package main.java.exceptions;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstruction extends RuntimeException {
    InvalidDFAConstruction(String msg) {
        super(msg);
    }

    InvalidDFAConstruction() {

    }
}
