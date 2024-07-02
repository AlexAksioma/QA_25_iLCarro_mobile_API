package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    MobileElement btnAddCar;

    public AddNewCarScreen clickBtnAddCar(){
        btnAddCar.click();
        return new AddNewCarScreen(driver);
    }

}
