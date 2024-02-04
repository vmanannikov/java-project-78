package hexlet.code.schemas;

import hexlet.code.Validator;

public class StringSchema extends BaseSchema<String> {
    public StringSchema(Validator validator) {
        super(validator);
    }

    public StringSchema required() {
        super.addCheck(value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.addCheck(value -> value.length() >= minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        super.addCheck(value -> value.contains(substring));
        return this;
    }
}
