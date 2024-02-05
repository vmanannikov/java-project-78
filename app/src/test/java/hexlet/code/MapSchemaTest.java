package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapSchemaTest {
    private static Validator validator;

    @BeforeAll
    static void getValidator() {
        validator = new Validator();
    }

    @Test
    @Order(1)
    public void testRequired() {
        MapSchema mapSchema = validator.map().required();

        assertTrue(mapSchema.isValid(Map.of()));
        assertFalse(mapSchema.isValid(null));
    }

    @Test
    @Order(2)
    public void testSizeof() {
        MapSchema mapSchema = validator.map().required().sizeof(2);

        assertTrue(mapSchema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertFalse(mapSchema.isValid(Map.of("key1", "value1")));
        assertFalse(mapSchema.isValid(null));
    }

    @Test
    @Order(3)
    public void testKeyExists() {
        MapSchema mapSchema = validator.map().required().key("name");

        assertTrue(mapSchema.isValid(Map.of("name", "John Doe")));
        assertFalse(mapSchema.isValid(Map.of("age", 30)));
        assertFalse(mapSchema.isValid(null));
    }

    @Test
    @Order(4)
    public void testValueIsValid() {
        MapSchema mapSchema = validator.map().required().value("name", validator.string().required());

        assertTrue(mapSchema.isValid(Map.of("name", "John Doe")));
        assertFalse(mapSchema.isValid(Map.of("age", "John Doe")));
        assertFalse(mapSchema.isValid(null));
    }

    @Test
    @Order(5)
    public void testShape() {
        MapSchema mapSchema = validator.map().required();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        mapSchema.shape(schemas);

        var map1 = new HashMap<String, Object>();
        map1.put("firstName", "John");
        map1.put("lastName", "Smith");
        assertTrue(mapSchema.isValid(map1));

        var map2 = new HashMap<String, Object>();
        map2.put("firstName", "John");
        assertFalse(mapSchema.isValid(map2));

        var map3 = new HashMap<String, Object>();
        map3.put("firstName", "John");
        map3.put("lastName", null);
        assertFalse(mapSchema.isValid(map3));
    }

}
