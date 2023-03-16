package homework2.ratelimitedprinter;

public class RateLimitedPrinterTest {
    public static void main(String[] args) {
        RateLimitedPrinter rlp = new RateLimitedPrinter(1000);
        for (int i = 0; i < 1_000_000_000; i++) {
            rlp.print(String.valueOf(i));
        }
    }
}
