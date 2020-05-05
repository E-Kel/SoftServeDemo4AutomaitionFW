import constants.URL;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.createAnAccountPage.CreateAnAccountAllFields;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForRegistration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CreateAnAccountPageTest {

    // a few trublles with this test. How to validate it? (response in console after execution)
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArgumentsForAccountCreation")
    void verifyFieldsOnCreateAndAccountPageWithValidData(String testEmail,
                                                         String pass,
                                                         String fname,
                                                         String lname,
                                                         String address,
                                                         String city,
                                                         String  zip,
                                                         String phone){
        CreateAnAccountAllFields accountAllFields= new CreateAnAccountAllFields();
        Response response = accountAllFields.createAnAccount(
                                                                testEmail,
                                                                pass,
                                                                fname,
                                                                lname,
                                                                address,
                                                                city,
                                                                zip,
                                                                phone);
     System.out.println(response.getBody().print());

        assertEquals(200, response.statusCode());



    }

    static Stream<Arguments> provideArgumentsForAccountCreation() {
        return Stream.generate(()->
                arguments(emailGenerator(),
                        passwordGenerator(),
                        fNameGenerator(),
                        lNameGenerator(),
                        addressGenerator(),
                        cityGenerator(),
                        zipCodeGenerator(),
                        phoneNumberGenerator()
               )).limit(5);
    }


}