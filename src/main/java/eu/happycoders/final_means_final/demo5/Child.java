package eu.happycoders.final_means_final.demo5;

import java.util.Objects;

class Child extends Base {
    private final String s;
    private final int i;

    Child(String s, int i) {
        this.s = s;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return i == child.i && Objects.equals(s, child.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }

    @Override
    public String toString() {
        return "Child{s='%s', i=%d}".formatted(s, i);
    }
}