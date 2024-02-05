package hexlet.code.schemas;

import java.util.Map;

public class MapSchema<String, T> extends BaseSchema<Map<String, T>> {

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

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        super.addCheck(value -> {
            for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
                Object keyValue = value.get(entry.getKey());
                if (!entry.getValue().isValid(keyValue)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
