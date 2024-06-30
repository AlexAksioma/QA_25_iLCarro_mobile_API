package screens;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ErrorScreen extends BaseScreen {
    public ErrorScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//[@resource-id='android:id/button1']")
    MobileElement btnOk;

    public boolean validateErrorMessage(String text) {
        return textInElementPresent(errorMessage, text, 5);
    }
}
