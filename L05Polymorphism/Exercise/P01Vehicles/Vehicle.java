package L05Polymorphism.Exercise.P01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private final double FUEL_CONSUMPTION;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double FUEL_CONSUMPTION, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.FUEL_CONSUMPTION = FUEL_CONSUMPTION;
        this.tankCapacity = tankCapacity;
    }

    public void drive(double distance) {

        double neededFuel = distance * FUEL_CONSUMPTION;

        if (fuelQuantity >= neededFuel) {
            fuelQuantity -= neededFuel;

            DecimalFormat df = new DecimalFormat("###.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }

    }

    public void refuel(double fuelQuantityRefill) {
        if (fuelQuantityRefill <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (fuelQuantityRefill + fuelQuantity > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuelQuantityRefill;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }

}
