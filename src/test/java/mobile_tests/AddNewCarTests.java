package mobile_tests;

import config.AppiumConfig;
import dto.CarDTO;
import dto.UserDTO;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {
    UserDTO user = UserDTO.builder()
            .username("0bagginsbob@mail.com")
            .password("Qwerty123!")
            .build();
    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000) + 1000;
        CarDTO car = CarDTO.builder()
                .serialNumber("333-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                //.fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("B")
                .pricePerDay(1.23)
                .city("Netanya")
                .build();
        new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .clickBtnDots()
                .clickBtnMyCars()
                .clickBtnAddCar()
                .typeAddNewCarForm(car)
                ;

    }
}
