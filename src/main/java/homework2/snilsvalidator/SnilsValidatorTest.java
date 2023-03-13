package homework2.snilsvalidator;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        boolean b = new SnilsValidatorImpl().validate("901-144-044-41");
        System.out.println(b);
    }
}
