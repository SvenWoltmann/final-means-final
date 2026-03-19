package eu.happycoders.final_means_final.demo4;

class ChildFixed extends Base {
    private final String s;
    private final int i;

    ChildFixed(String s, int i) {
        this.s = s;
        this.i = i;
        super();
    }

    @Override
    public String toString() {
        return "s = %-8s i = %5d".formatted(s, i);
    }
}