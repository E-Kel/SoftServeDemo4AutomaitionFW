package api.constants;

import static api.constants.Constants.*;

public class TestDataGeneratorForRegistration {

    private static int intGenerator(int start, int numbers) {
        return (int) ((Math.random() * (numbers - start)) + start);
    }

    private static int intGenerator(int length) {
        return (int) (Math.random() * length);

    }

    private static String simpleStringGenerator(String charset, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(charset.charAt(intGenerator(charset.length())));
        return sb.toString();
    }

    public static String emailGenerator() {
        return simpleStringGenerator(EMAIL_SYMBOLS, intGenerator(1, 20)) + "@gmail.com";
    }
}
