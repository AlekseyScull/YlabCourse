package homework2.snilsvalidator;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        boolean b = new SnilsValidatorImpl().validate("90114404441");
        System.out.println(b);
    }
}
