package main.java;

import java.lang.reflect.Executable;

/**
 * Created by ndrei on 2017-05-10.
 */
abstract class Automaton {
    State cur_state;
    Input input;
    Output output;

    protected void transition() {
        Character next_char = input.get();
        cur_state = next_state();

        for (Executable e : output()) {
            // TODO: execute e
        }
    }

    abstract Iterable<Executable> output();

    abstract State next_state();
}
