package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testRequired() {
        StringSchema schema = validator.string().required();

        assertTrue(schema.isValid("Hello"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    @Order(2)
    public void testMinLength() {
        StringSchema schema = validator.string().required().minLength(5);

        assertTrue(schema.isValid("This is a string"));
        assertFalse(schema.isValid("abc"));
        assertFalse(schema.isValid(""));
    }

    @Test
    @Order(3)
    public void testContains() {
        StringSchema schema = validator.string().required().contains("hex");

        assertTrue(schema.isValid("This is a hex string"));
        assertFalse(schema.isValid("This is a string"));
        assertFalse(schema.isValid(""));
    }
}
