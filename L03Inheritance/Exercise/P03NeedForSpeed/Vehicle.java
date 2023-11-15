package L03Inheritance.Exercise.P03NeedForSpeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private  double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle (double fuel, int horsePower){
        setFuel(fuel);
        setHorsePower(horsePower);
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void drive (double kilometers){
        double neededFuel = kilometers * fuelConsumption;

        if (fuel >= neededFuel){
            setFuel(fuel - neededFuel);
        } else {
            throw new IllegalArgumentException("not enough fuel");
        }
    }
}
