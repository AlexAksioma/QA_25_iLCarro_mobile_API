package screens;

import dto.CarDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

public class AddNewCarScreen extends BaseScreen{
    public AddNewCarScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    int heightScreen = getScreenSize()[0];
    int widthScreen = getScreenSize()[1];
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editSerial']")
    MobileElement fieldSerialNumber;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editMan']")
    MobileElement fieldManufacture;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editModel']")
    MobileElement fieldModel;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCity']")
    MobileElement fieldCity;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editPrice']")
    MobileElement fieldPrice;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCarClass']")
    MobileElement fieldCarClass;

    public AddNewCarScreen typeAddNewCarForm(CarDTO car){
        fieldSerialNumber.sendKeys(car.getSerialNumber());
        fieldManufacture.sendKeys(car.getManufacture());
        fieldModel.sendKeys(car.getModel());
        fieldCity.sendKeys(car.getCity());
        fieldPrice.sendKeys(Double.toString(car.getPricePerDay()));
        fieldCarClass.sendKeys(car.getCarClass());
        System.out.println(heightScreen+"X"+widthScreen);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(widthScreen/100, heightScreen/4*3))
                .moveTo(PointOption.point(widthScreen/100, heightScreen/4))
                .release().perform();

        return this;
    }
}
