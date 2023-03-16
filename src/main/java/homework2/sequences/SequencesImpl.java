package homework2.sequences;

public class SequencesImpl implements Sequences {
    @Override
    public void a(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i * 2 + " ");
        }
        System.out.println();
    }

    @Override
    public void b(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((i * 2 - 1) + " ");
        }
        System.out.println();
    }

    @Override
    public void c(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }

    @Override
    public void d(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((i * i * i) + " ");
        }
        System.out.println();
    }

    @Override
    public void e(int n) {
        int result;
        for (int i = 1; i <= n; i++) {
            result = i % 2 == 0 ? -1 : 1;
            System.out.print(result + " ");
        }
        System.out.println();
    }

    @Override
    public void f(int n) {
        int result;
        for (int i = 1; i <= n; i++) {
            result = (i % 2 == 0 ? -1 : 1) * i;
            System.out.print(result + " ");
        }
        System.out.println();
    }

    @Override
    public void g(int n) {
        int result;
        for (int i = 1; i <= n; i++) {
            result = (i % 2 == 0 ? -1 : 1) * i * i;
            System.out.print(result + " ");
        }
        System.out.println();
    }

    @Override
    public void h(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(counter++ + " ");
            }
            else {
                System.out.print(0 + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void i(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            System.out.print(result + " ");
        }
        System.out.println();
    }

    @Override
    public void j(int n) {
        long[] fib = new long[n + 1];
        fib[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (i < 2) {
                System.out.print(fib[i] + " ");
            }
            else {
                fib[i] = fib[i - 1] + fib[i - 2];
                System.out.print(fib[i] + " ");
            }
        }
        System.out.println();
    }
}
