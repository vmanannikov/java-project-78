package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringSchemaTest {
    private static Validator validator;
    private static StringSchema schema;

    @BeforeAll
    static void getValidator() {
        validator = new Validator();
        schema = validator.string();
    }

    @Test
    @Order(1)
    void checkNull() {
        var actual = schema.isValid(null);
        assertThat(actual).isTrue();
    }

    @Test
    @Order(2)
    void checkEmptyString() {
        var actual = schema.isValid("");
        assertThat(actual).isTrue();
    }

    @Test
    @Order(3)
    void checkRequired() {
        var actual =  schema.required().isRequired();
        assertThat(actual).isTrue();
    }

    @Test
    @Order(4)
    void checkNullEmptyAfterRequired() {
        var actual = schema.isValid(null);
        assertThat(actual).isFalse();
    }

    @Test
    @Order(5)
    void checkEmptyStringAfterRequired() {
        var actual = schema.isValid("hexlet");
        assertThat(actual).isTrue();
    }

    @Test
    @Order(6)
    void checkStringContainsAfterRequired() {
        var actual = schema.contains("wh").isValid("what does the fox say");
        assertThat(actual).isTrue();
    }
}
