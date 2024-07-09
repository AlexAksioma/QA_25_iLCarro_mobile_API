package api_tests;

import api.CarController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUserCarTestsRest extends CarController {
    @Test
    public void getAllUserCarPositiveTest(){
        Assert.assertEquals(statusCodeAllUserCarResponse(), 200);
    }
}
