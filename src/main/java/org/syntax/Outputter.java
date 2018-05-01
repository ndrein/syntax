package org.syntax;

public interface Outputter<InputT> {
    void output(State q, InputT c);
}
