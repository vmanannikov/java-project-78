package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        super.addCheck(value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        super.addCheck(value -> value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        super.addCheck(value -> value >= min && value <= max);
        return this;
    }
}

