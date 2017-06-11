package main.java;

public interface Outputter<InputT> {
    void output(State q, InputT c);
}
