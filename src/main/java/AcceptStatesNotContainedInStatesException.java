package main.java;

/**
 * Created by ndrei on 2017-05-02.
 */
public class AcceptStatesNotContainedInStatesException extends InvalidDFAConstructionException {
    public AcceptStatesNotContainedInStatesException(String msg) {
        super(msg);
    }
}
