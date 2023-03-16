package homework1;

import java.util.Scanner;

public class Pell {
    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            while (n < 0 || n > 30) {
                System.out.println("enter number from 0 to 30");
                n = scanner.nextInt();
            }
        }
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                arr[i] = i;
            } else {
                arr[i] = 2 * arr[i - 1] + arr[i - 2];
            }
        }
        System.out.println(arr[n]);
    }
}
