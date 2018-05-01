package org.syntax;


import java.util.Objects;

public class State {
    final private int integer;

    public State(int i) {
        this.integer = i;
    }

    int getInt() {
        return integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return integer == state.integer;
    }

    @Override
    public int hashCode() {

        return Objects.hash(integer);
    }
}
