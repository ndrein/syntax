package main.java;


public class State {
    final private Integer integer;

    public State(Integer i) {
        this.integer = i;
    }

    public Integer getInt() {
        return integer;
    }

    @Override
    public boolean equals(Object other) {
        return other.getClass() == this.getClass() && ((State) other).integer.equals(integer);
    }

    @Override
    public int hashCode() {
        return integer.hashCode();
    }
}
