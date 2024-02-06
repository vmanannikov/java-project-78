package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

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
