package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema  {
    private boolean required;
    private int minLength;
    private String contains;
    public StringSchema required() {
        this.required = !this.required;
        return this;
    }

    public StringSchema minLength(int num) {
        this.minLength = num;
        return this;
    }

    public StringSchema contains(String letters) {
        this.contains = letters;
        return this;
    }

    public boolean isValid(Object o) {
        if (!(o instanceof String) && o != null) {
            return false;
        }

        if (this.required && (o == null || ((String) o).isEmpty())) {
            return false;
        }

        if (this.contains != null && !((String) o).contains(this.contains)) {
            return false;
        }
        return true;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StringSchema schema = (StringSchema) o;
        return required == schema.required
                && minLength == schema.minLength
                && Objects.equals(contains, schema.contains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(required, minLength, contains);
    }
}
