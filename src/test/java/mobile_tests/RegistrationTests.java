package mobile_tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .username(i + "jon_dou@mail.com")
                .password("Qwerty123!")
                .lastName("Dou")
                .firstName("Jon")
                .build();
        Assert.assertTrue(new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .fillRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Registration success!"))
        ;
    }

    @Test
    public void registrationNegativeTest_emptyLastName() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .username(i + "jon_dou@mail.com")
                .password("Qwerty123!")
                .lastName(" ")
                .firstName("Jon")
                .build();
        Assert.assertTrue(new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .fillRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaNegative()
                .validateErrorMessage("All fields must be filled and agree terms"))
        ;
    }

    @Test
    public void registrationNegativeTest_WOCheckBox() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .username(i + "jon_dou@mail.com")
                .password("Qwerty123!")
                .lastName("Dou")
                .firstName("Jon")
                .build();
        Assert.assertTrue(new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .fillRegistrationForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("All fields must be filled and agree terms"))
        ;
    }

    @Test
    public void registrationNegativeTest_wrongEmail() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .username(i + "jon_doumail.com")
                .password("Qwerty123!")
                .lastName("Dou")
                .firstName("Jon")
                .build();
        Assert.assertTrue(new SplashScreen(driver).goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .fillRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaNegative()
                .validateErrorMessage("username=must be a well-formed email address"))
        ;
    }
}
