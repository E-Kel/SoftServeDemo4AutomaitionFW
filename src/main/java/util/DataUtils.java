package util;

import constants.Cookie;
import constants.Tokens;
import org.junit.jupiter.params.provider.Arguments;

import java.util.HashMap;
import java.util.stream.Stream;

import static constants.ResultValues.*;
import static constants.TestDataGeneratorForAddingToCartWithProperties.generateIpa;
import static constants.TestDataGeneratorForAddingToCartWithProperties.generateQTY;
import static constants.TestDataGeneratorForRegistration.emailGenerator;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataUtils {
    private static HashMap<Object, Object> IDs_AND_IPA;

    private DataUtils() {

    }

    public static Stream<Arguments> provideArgumentsValidSearchData() {
        return Stream.of(
                arguments("Tops", TOPS_RESULT),
                arguments("Dresses", DRESSES_RESULT),
                arguments("T-shirts", T_SHIRTS_RESULT),
                arguments("Casual dresses", CASUAL_DRESSES_RESULT),
                arguments("Summer dresses", SUMMER_DRESSES_RESULT),
                arguments("Evening dresses", EVENING_DRESSES_RESULT),
                arguments("Woman", WOMAN_RESULT),
                arguments("Blouses", BLOUSE_RESULT)
        );
    }

    public static Stream<Arguments> provideArgumentsInvalidSearchData() {
        return Stream.of(
                arguments(" "),
                arguments("1234567890"),
                arguments("!@#$%^&*()_+~`{}[];:'\"/?.,<>№|/"),
                arguments("абвгдеёжзийклмнопрстуфхцчшщъыьэюя"),
                arguments("платье"),
                arguments("1234567890!@#$%^&*()_+"),
                arguments("null")
        );
    }

    static Stream<Arguments> provideEmail() {
        return Stream.generate(() ->
                arguments(Cookie.STATIC_COOKIE, emailGenerator())).limit(10);
    }

    static Stream<Arguments> provideArgumentsForAddingToCartWithDifSizeAndColor() {
        return Stream.generate(() ->
                arguments(generateQTY(), generateIpa(), Tokens.TOKEN)).limit(10);
    }
}