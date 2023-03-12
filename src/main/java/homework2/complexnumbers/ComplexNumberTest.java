package homework2.complexnumbers;

public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(4, 3);
        ComplexNumber b = new ComplexNumber(2, 2);
        System.out.println(a.sum(b));
        System.out.println(a.subtract(b));
        System.out.println(a.mult(b));
        System.out.println(a.div(b));
        System.out.println(a.modulus());

        ComplexNumber c = a.div(new ComplexNumber(0)).mult(new ComplexNumber(2));
        System.out.println(c);
    }
}
