package homework1;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int number = new Random().nextInt(99) + 1;
        int maxAttempts = 10;
        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = maxAttempts - 1; i >= 0; i--) {
                int guess = scanner.nextInt();
                if (guess == number) {
                    System.out.println("Ты угадал с " + (maxAttempts - i) + " попытки!");
                    break;
                }
                if (i > 0) {
                    if (guess < number) {
                        System.out.print("Мое число больше! ");
                    } else {
                        System.out.print("Мое число меньше! ");
                    }
                    System.out.println("У тебя осталось " + (i) + " попыток");
                } else System.out.println("Ты не угадал");
            }
        }
    }
}
