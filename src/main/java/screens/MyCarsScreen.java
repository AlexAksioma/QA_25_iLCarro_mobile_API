package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    int heightScreen = getScreenSize()[0];
    int widthScreen = getScreenSize()[1];
    int listCarsStart=0;
    //int listCarsEnd=0;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    MobileElement btnAddCar;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    MobileElement popUpMessageCarWasAdded;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement popUpMessageBtnYes;




    public AddNewCarScreen clickBtnAddCar(){
        btnAddCar.click();
        return new AddNewCarScreen(driver);
    }
    public boolean isElementPresent_popUpMessageSuccess(String text){
        return textInElementPresent(popUpMessageCarWasAdded, text, 5);
    }

    public MyCarsScreen deleteFirstCar() {
        List<MobileElement> listCars = driver.findElements(
                By.xpath("//*[@resource-id='com.telran.ilcarro:id/LinearLayout']"));
        listCarsStart = listCars.size();
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(widthScreen/6*5, heightScreen/4))
                .moveTo(PointOption.point(widthScreen/6, heightScreen/4))
                .release().perform();
        return this;
    }
    public MyCarsScreen clickBtnPopUpYes(){
        popUpMessageBtnYes.click();
        return this;
    }
    public boolean validateDeleteCar(){
        List<MobileElement> listCars = driver.findElements(
                By.xpath("//*[@resource-id='com.telran.ilcarro:id/LinearLayout']"));
        if(listCars.size() == listCarsStart-1)
            return true;
        else
            return false;
    }
}
