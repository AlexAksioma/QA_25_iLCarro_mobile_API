package enums;

public enum Fuel {
    DIESEL("//*[@text='Diesel' and @resource-id='com.telran.ilcarro:id/text1']"),
    //PETROL("Petrol"),
    HYBRID("Hybrid"),
    ELECTRIC("Electric"),
    GAS("//*[@text()='Gas' and @resource-id='com.telran.ilcarro:id/text1']");
    private final String fuel;
    Fuel(String fuel) {
        this.fuel = fuel;
    }
    public String getFuel() {
        return fuel;
    }
}
