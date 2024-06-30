package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen{
    public RegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    MobileElement fieldFirstName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    MobileElement fieldLastName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    MobileElement checkBoxIAgree;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    MobileElement btnYalla;

    public RegistrationScreen fillRegistrationForm(UserDTO user) {
        fieldFirstName.sendKeys(user.getFirstName());
        fieldLastName.sendKeys(user.getLastName());
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
        return this;
    }
    public RegistrationScreen clickCheckBoxIAgree(){
        checkBoxIAgree.click();
        return this;
    }
    public SearchScreen clickBtnYallaPositive(){
        btnYalla.click();
        return new SearchScreen(driver);
    }
    public ErrorScreen clickBtnYallaNegative(){
        btnYalla.click();
        return new ErrorScreen(driver);
    }
}
