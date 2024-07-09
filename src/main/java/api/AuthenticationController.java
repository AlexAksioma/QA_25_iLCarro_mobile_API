package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.ErrorMessageDto;
import dto.RegistrationBodyDto;
import dto.TokenDto;
import interfaces.BaseApi;

import static com.jayway.restassured.RestAssured.given;

public class AuthenticationController implements BaseApi {

    private static Response registrationLogin(RegistrationBodyDto registrationBodyDto, String url){
        return given()
                .body(registrationBodyDto)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+url)
                .thenReturn();
    }

    public int statusCodeResponseRegLogin(RegistrationBodyDto registrationBodyDto, String url){
        return registrationLogin(registrationBodyDto, url).getStatusCode();
    }

    public ErrorMessageDto bodyNegativeResponseRegLogin(RegistrationBodyDto registrationBodyDto, String url){
        return registrationLogin(registrationBodyDto, url).getBody().as(ErrorMessageDto.class);
    }
    public static String tokenResponseRegLogin(RegistrationBodyDto registrationBodyDto, String loginUrl) {
        return registrationLogin(registrationBodyDto, loginUrl).getBody().as(TokenDto.class).getAccessToken();
    }

}
