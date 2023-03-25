package homework3.passwordvalidator;

import homework3.passwordvalidator.exceptions.WrongLoginException;
import homework3.passwordvalidator.exceptions.WrongPasswordException;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        String login;
        String password;
        String confirm;
        try (Scanner scanner = new Scanner(System.in)) {
            login = scanner.nextLine();
            password = scanner.nextLine();
            confirm = scanner.nextLine();
        }
        System.out.println(validate(login, password, confirm));
    }

    private static boolean validate(String login, String password, String confirm) {
        boolean result = true;
        try {
            if (!login.matches("\\w+")) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } else if (login.length() >= 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }

            if (!password.matches("\\w*")) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } else if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль слишком длинный");
            } else if (!password.equals(confirm)) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }
}
