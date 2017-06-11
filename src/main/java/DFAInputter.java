package main.java;

import java.util.List;

public class DFAInputter implements Inputter<Character> {
    private List<Character> input;
    private int i = 0;

    @Override
    public Character get() {
        return input.get(i);
    }
}
