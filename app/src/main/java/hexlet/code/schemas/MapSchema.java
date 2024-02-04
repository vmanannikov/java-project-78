package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, Object>> {

    public MapSchema(Validator validator) {
        super(validator);
    }

    public MapSchema required() {
        super.addCheck(value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addCheck(value -> value.size() == size);
        return this;
    }

    public MapSchema key(String key) {
        super.addCheck(value -> value.containsKey(key));
        return this;
    }

    public MapSchema value(String key, BaseSchema schema) {
        super.addCheck(value -> value.containsKey(key) && schema.isValid(value.get(key)));
        return this;
    }
}
