package homework2.complexnumbers;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber sum(ComplexNumber number) {
        return new ComplexNumber(this.real + number.real,
                this.imaginary + number.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber number) {
        return new ComplexNumber(this.real - number.real,
                this.imaginary - number.imaginary);
    }

    public ComplexNumber mult(ComplexNumber number) {
        double realPart = this.real * number.real - this.imaginary * number.imaginary;
        double imaginaryPart = this.imaginary * number.real + this.real * number.imaginary;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber div(ComplexNumber number) {
        double a = this.real;
        double b = this.imaginary;
        double c = number.real;
        double d = number.imaginary;
        //if (c == 0 && d == 0) throw new ArithmeticException("Division by zero...");
        double denom = c * c + d * d;
        double realPart = (a * c + b * d) / denom;
        double imaginaryPart = (b * c - a * d) / denom;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public double modulus() {
        double result = Math.pow(this.real, 2) + Math.pow(this.imaginary, 2);
        return Math.sqrt(result);
    }

    @Override
    public String toString() {
        String result = "0";
        if (real != 0 && imaginary == 0) {
            result = real + "";
        }
        else if (imaginary != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(real);
            if (imaginary < 0) {
                sb.append(" - ");
            }
            else {
                sb.append(" + ");
            }
            if (Math.abs(imaginary) != 1) {
                sb.append(Math.abs(imaginary));
            }
            sb.append("i");
            result = sb.toString();
        }
        return result;

    }
}
