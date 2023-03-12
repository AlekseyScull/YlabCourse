package homework2.ratelimitedprinter;

public class RateLimitedPrinter {
    private int interval;
    private long lastTime;

    public RateLimitedPrinter(int interval) {
        this.interval = interval;
    }

    public void print(String string) {
        if (System.currentTimeMillis() - lastTime > interval) {
            System.out.println(string);
            lastTime = System.currentTimeMillis();
        }
    }
}
