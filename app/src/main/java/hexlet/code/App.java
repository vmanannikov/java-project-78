package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();

        var schema = v.number();

        schema.isValid(5); // true

        // Пока не вызван метод required(), null считается валидным
        schema.isValid(null); // true
        schema.positive().isValid(null); // true

        schema.required();

        schema.isValid(null); // false
        schema.isValid(10); // true

        // Потому что ранее мы вызвали метод positive()
        schema.isValid(-10); // false
        //  Ноль — не положительное число
        schema.isValid(0); // false

        schema.range(5, 10);

        schema.isValid(5); // true
        schema.isValid(10); // true
        schema.isValid(4); // false
        schema.isValid(11); // false
    }
}
