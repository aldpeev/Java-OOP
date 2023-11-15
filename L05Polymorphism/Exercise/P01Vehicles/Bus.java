package L05Polymorphism.Exercise.P01Vehicles;

public class Bus extends Vehicle{
    private static double addedFuelConsumption = 1.4;

    public Bus(double fuelQuantity, double FUEL_CONSUMPTION, double tankCapacity) {
        super(fuelQuantity, FUEL_CONSUMPTION + addedFuelConsumption, tankCapacity);
    }

    public void emptyBusConsumption(){
        addedFuelConsumption = 0.9;
    }
}
