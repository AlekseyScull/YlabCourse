package homework2.snilsvalidator;

public class SnilsValidatorImpl implements SnilsValidator {
    @Override
    public boolean validate(String snils) {
        boolean result = false;
        String formattedString = snils.replaceAll("\\D", "");
        int checkDigit = Integer.parseInt(formattedString.substring(9));
        char[] arr = formattedString.toCharArray();
        if (arr.length == 11) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.digit(arr[i], 10) * (9 - i);
            }
            if ((sum < 100 && sum == checkDigit) ||
                    (sum > 101 && checkDigit == sum % 101) ||
                    (sum % 101 == 100 && checkDigit == 0)) {
                result = true;
            }
        }
        return result;
    }
}
