package main.java;

class Termination extends Exception {
    private State final_state;
    private Boolean is_accepted;

    public Termination(State final_state, Boolean is_accepted) {
        this.final_state = final_state;
        this.is_accepted = is_accepted;
    }

    public Boolean get_accepted() {
        return this.is_accepted;
    }

    public State get_final_state() {
        return this.final_state;
    }
}
