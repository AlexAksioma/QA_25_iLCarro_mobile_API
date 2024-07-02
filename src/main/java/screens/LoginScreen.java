package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement btnYalla;

    public LoginScreen typeLoginForm(UserDTO user){
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
        return this;
    }

    public SearchScreen clickBtnYallaPositive() {
        btnYalla.click();
        return new SearchScreen(driver);
    }

    public ErrorScreen clickBtnYallaNegative() {
        btnYalla.click();
        return new ErrorScreen(driver);
    }
}
