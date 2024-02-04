package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapSchemaTest {
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
        MapSchema schema = validator.map().required();

        assertTrue(schema.isValid(Map.of()));
        assertFalse(schema.isValid(null));
    }

    @Test
    @Order(2)
    public void testSizeof() {
        MapSchema schema = validator.map().required().sizeof(2);

        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertFalse(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(null));
    }

    @Test
    @Order(3)
    public void testKeyExists() {
        MapSchema schema = validator.map().required().key("name");

        assertTrue(schema.isValid(Map.of("name", "John Doe")));
        assertFalse(schema.isValid(Map.of("age", 30)));
        assertFalse(schema.isValid(null));
    }

    @Test
    @Order(4)
    public void testValueIsValid() {
        MapSchema schema = validator.map().required().value("name", validator.string());

        assertTrue(schema.isValid(Map.of("name", "John Doe")));
        assertFalse(schema.isValid(Map.of("age", "John Doe")));
        assertFalse(schema.isValid(null));
    }
}
