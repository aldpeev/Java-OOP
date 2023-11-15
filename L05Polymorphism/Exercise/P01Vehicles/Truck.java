package L05Polymorphism.Exercise.P01Vehicles;

public class Truck extends Vehicle {
    private static final double ADDED_FUEL_CONSUMPTION_ON_AIR_CONDITIONER = 1.6;
    private static final double PERCENTAGE = 0.95;


    public Truck(double fuelQuantity, double FUEL_CONSUMPTION, double tankCapacity) {
        super(fuelQuantity, FUEL_CONSUMPTION + ADDED_FUEL_CONSUMPTION_ON_AIR_CONDITIONER, tankCapacity);
    }

    @Override
    public void refuel(double fuelQuantityRefill) {
       super.refuel(fuelQuantityRefill * 0.95);
    }
}
