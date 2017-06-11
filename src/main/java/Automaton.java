package main.java;

import java.lang.reflect.Executable;


abstract class Automaton<InputT> {
    State cur_state;
    Inputter<InputT> data;
    Outputter<InputT> outputter;

    protected void transition() {
        InputT input = data.get();
        cur_state = next_state(cur_state, input);
        outputter.output(cur_state, input);
    }

    abstract Iterable<Executable> output();

    abstract State next_state(State cur_state, InputT input);
}
