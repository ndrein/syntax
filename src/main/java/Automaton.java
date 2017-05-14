package main.java;

import java.lang.reflect.Executable;

/**
 * Created by ndrei on 2017-05-10.
 */
abstract class Automaton<InputT> {
    State cur_state;
    Input<InputT> data;
    Output output;

    protected void transition() {
        InputT next_char = data.get();
        cur_state = next_state(cur_state, next_char);

        for (Executable e : output()) {
            // TODO: execute e
        }
    }

    abstract Iterable<Executable> output();

    abstract State next_state(State cur_state, InputT input);
}
