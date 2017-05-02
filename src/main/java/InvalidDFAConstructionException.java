package main.java;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidDFAConstructionException extends RuntimeException {
    InvalidDFAConstructionException(String msg) {
        super(msg);
    }

    InvalidDFAConstructionException() {

    }
}
