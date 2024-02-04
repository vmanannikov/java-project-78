package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Validator validator;
    protected List<Predicate<T>> checks = new ArrayList<>();

    public BaseSchema(Validator validator) {
        this.validator = validator;
    }

    public void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    public boolean isValid(T value) {
        for (Predicate<T> check : checks) {
            if (!check.test(value)) {
                return false;
            }
        }
        return true;
    }
}