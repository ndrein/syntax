package main.java;

import java.util.List;

public class DFAInput implements Input, Output {
    private List<Character> input;
    private int i = 0;

    @Override
    public Character get() {
        return input.get(i);
    }

    @Override
    public void output(State q, Character c) {
    }
}
