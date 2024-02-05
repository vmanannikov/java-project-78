package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberSchemaTest {
    private static Validator validator;

    @BeforeAll
    static void getValidator() {
        validator = new Validator();
    }
    @Test
    @Order(1)
    public void testRequired() {
        NumberSchema schema = validator.number().required();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(null));
    }

    @Test
    @Order(2)
    public void testPositive() {
        NumberSchema schema = validator.number().required().positive();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
        assertFalse(schema.isValid(null));
    }

    @Test
    @Order(3)
    public void testRange() {
        NumberSchema schema = validator.number().required().range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
        assertFalse(schema.isValid(null));
    }
}
