package L05Polymorphism.Exercise.P01Vehicles;

public class Car extends Vehicle{
    private static final double ADDED_FUEL_CONSUMPTION_ON_AIR_CONDITIONER = 0.9;


    public Car(double fuelQuantity, double FUEL_CONSUMPTION, double tankCapacity) {
        super(fuelQuantity, FUEL_CONSUMPTION + ADDED_FUEL_CONSUMPTION_ON_AIR_CONDITIONER, tankCapacity);
    }
}
