package api_tests;

import api.AuthenticationController;
import dto.ErrorMessageDto;
import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .firstName("Frodo")
                .lastName("Baggins")
                .username("qa_baggins" + new Random().nextInt(1000) + "@dot.com")
                .password("Qwerty123!_")
                .build();
        Assert.assertEquals(statusCodeResponseRegLogin(registrationBodyDto, REGISTRATION_URL), 200);
    }
    @Test
    public void registrationNegativeTest_wrongEmail(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .firstName("Frodo")
                .lastName("Baggins")
                .username("qa_baggins" + new Random().nextInt(1000) + "dot.com")
                .password("Qwerty123!_")
                .build();
        ErrorMessageDto errorMessageDto = bodyNegativeResponseRegLogin(registrationBodyDto, REGISTRATION_URL);
        softAssert.assertEquals(statusCodeResponseRegLogin(registrationBodyDto, REGISTRATION_URL), 400);
        softAssert.assertEquals(errorMessageDto.getError(), "Bad Request");
        softAssert.assertTrue(errorMessageDto.getMessage().toString().contains("must be a well-formed email address"));
        softAssert.assertAll();
    }
}
