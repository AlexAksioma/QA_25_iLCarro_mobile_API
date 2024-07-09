package api_tests;

import api.CarController;
import dto.CarDTO;
import enums.Fuel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTestsRest extends CarController {
    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000) + 1000;
        CarDTO car = CarDTO.builder()
                .serialNumber("333-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.ELECTRIC.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        Assert.assertEquals(statusCodeAddNewCarResponse(car, token), 200);
    }
    @Test
    public void addNewCarNegativeTest_wrongToken(){
        int i = new Random().nextInt(1000) + 1000;
        CarDTO car = CarDTO.builder()
                .serialNumber("555-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.ELECTRIC.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        Assert.assertEquals(statusCodeAddNewCarResponse(car, ""), 403);
    }

}
