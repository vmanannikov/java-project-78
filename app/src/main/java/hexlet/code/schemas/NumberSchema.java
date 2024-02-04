package hexlet.code.schemas;

import hexlet.code.Range;

public class NumberSchema  {
    private boolean required;
    private boolean positive;
    private Range range;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.range = null;
    }

    public boolean isValid(Object value) {
        if (value == null) {
            if (required) {
                return false;
            }
        } else if (value instanceof Number) {
            if (positive && ((Number) value).intValue() <= 0) {
                return false;
            }
            if (range != null && !range.contains((Number) value)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public NumberSchema required() {
        this.required = !this.required;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.range = new Range(min,max);
        return this;
    }
}

