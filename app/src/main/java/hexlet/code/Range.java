package hexlet.code;

public class Range {
    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(Number value) {
        return value.intValue() >= min && value.intValue() <= max;
    }
}
