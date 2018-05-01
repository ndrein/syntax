package org.syntax.exceptions;

public class IncompleteTransitions extends InvalidDFAConstruction {
    public IncompleteTransitions(String msg) {
        super(msg);
    }
}
