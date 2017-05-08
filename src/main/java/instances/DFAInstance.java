package main.java.instances;

import main.java.DFA;

abstract public class DFAInstance extends DFA implements DFAInstanceImplementation {
    public DFAInstance() {
        super(alphabet, states, start_state, accept_states, transitions);
    }
}
