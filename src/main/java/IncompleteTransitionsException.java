package main.java;

/**
 * Created by ndrei on 2017-05-02.
 */
public class IncompleteTransitionsException extends InvalidDFAConstructionException {
    public IncompleteTransitionsException(String msg) {
        super(msg);
    }
}
