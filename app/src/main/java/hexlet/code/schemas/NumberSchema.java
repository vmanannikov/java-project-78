package hexlet.code.schemas;

import hexlet.code.Validator;

public class NumberSchema extends BaseSchema<Number>  {
    public NumberSchema(Validator validator) {
        super(validator);
    }

    public NumberSchema required() {
        super.addCheck(value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        super.addCheck(value -> value instanceof Integer && (Integer) value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        super.addCheck(value -> value instanceof Integer && (Integer) value >= min && (Integer) value <= max);
        return this;
    }
}

