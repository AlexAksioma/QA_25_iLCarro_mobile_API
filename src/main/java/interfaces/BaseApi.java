package interfaces;

import okhttp3.MediaType;

public interface BaseApi {
    String BASE_URL = "https://ilcarro-backend.herokuapp.com";
    String LOGIN_URL = "/v1/user/login/usernamepassword";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String EMAIL = "789baggins_bilbo@mail.com";
    String PASSWORD = "Zxc12345!";
    String ADD_NEW_CAR_URL = "/v1/cars";
    String GET_ALL_USER_CARS_URL = "/v1/cars/my";
    String DELETE_CAR_BY_SERIAL_NUMBER_URL = "/v1/cars/";
    MediaType JSON = MediaType.get("application/json");
}
