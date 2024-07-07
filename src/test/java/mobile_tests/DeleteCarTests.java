package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class DeleteCarTests extends AppiumConfig {
    UserDTO user = UserDTO.builder()
            .username("0bagginsbob@mail.com")
            .password("Qwerty123!")
            .build();
    @Test
    public void deleteCarPositiveTest(){
        Assert.assertTrue(new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .clickBtnDots()
                .clickBtnMyCars()
                .deleteFirstCar()
                .clickBtnPopUpYes()
                .validateDeleteCar())
                ;
    }
}
