package api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import dto.CarDTO;
import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import org.testng.annotations.BeforeSuite;

import static com.jayway.restassured.RestAssured.given;

public class CarController implements BaseApi {
    public static String token = "";
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void getTokenForCarController(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto
                .builder()
                .username(EMAIL)
                .password(PASSWORD)
                .build();
        token = AuthenticationController.tokenResponseRegLogin(registrationBodyDto, LOGIN_URL);
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();
    }

    private Response addNewCarResponse(CarDTO carDTO, String token){
        return given()
                .body(carDTO)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .post(BASE_URL+ADD_NEW_CAR_URL)
                .thenReturn();
    }

    public int statusCodeAddNewCarResponse(CarDTO carDTO, String token){
        return addNewCarResponse(carDTO, token).getStatusCode();
    }
    private Response getAllUserCarResponse(){
        return given()
                .spec(requestSpecification)
                .when()
                .get(BASE_URL + GET_ALL_USER_CARS_URL)
                .thenReturn();
    }
    public int statusCodeAllUserCarResponse(){
        return getAllUserCarResponse().getStatusCode();
    }



}
