package main.java;

abstract class Automaton<InputT> {
    private State cur_state;
    private Inputter<InputT> input;
    private Outputter<InputT> output;

    public Automaton(Outputter<InputT> output) {
        this.output = output;
    }

    private void transition() throws Termination {
        InputT input = this.input.get();
        cur_state = next_state(cur_state, input);
        output.output(cur_state, input);
    }

    public Boolean accepts(Inputter<InputT> input) {
        this.input = input;

        while (true) {
            try {
                this.transition();
            } catch (Termination termination) {
                return termination.get_accepted();
            }
        }
    }

    abstract State next_state(State cur_state, InputT input);
}

