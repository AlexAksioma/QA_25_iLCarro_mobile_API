package api_tests;

import api.AuthenticationController;
import dto.RegistrationBodyDto;
import org.testng.annotations.Test;

public class LoginTestsRest extends AuthenticationController {
    @Test
    public void loginPositiveTest(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto
                .builder()
                .username(EMAIL)
                .password(PASSWORD)
                .build();
        String token = tokenResponseRegLogin(registrationBodyDto, LOGIN_URL);
        System.out.println(token);
    }


}
