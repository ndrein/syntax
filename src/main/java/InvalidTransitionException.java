package main.java;

/**
 * Created by ndrei on 2017-05-02.
 */
public class InvalidTransitionException extends InvalidDFAConstructionException {
    public InvalidTransitionException(String msg) {
        super(msg);
    }
}
