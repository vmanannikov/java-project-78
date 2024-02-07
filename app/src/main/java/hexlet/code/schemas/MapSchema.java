package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<String, T> extends BaseSchema<Map<String, T>> {

    public MapSchema required() {
        super.addCheck(value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addCheck(value -> value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        super.addCheck(value -> {
            for (Map.Entry<String, BaseSchema<T>> entry : schemas.entrySet()) {
                T keyValue = value.get(entry.getKey());
                if (!entry.getValue().isValid(keyValue)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
