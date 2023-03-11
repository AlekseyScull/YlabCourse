package homework1;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        int n;
        int m;
        String template;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            template = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(template);
                if (j != m - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
