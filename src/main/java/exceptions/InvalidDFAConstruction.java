package main.java.exceptions;

public class InvalidDFAConstruction extends RuntimeException {
    InvalidDFAConstruction(String msg) {
        super(msg);
    }

    InvalidDFAConstruction() {

    }
}
