package L06Solid.Exercise.P01.products;

import L06Solid.Exercise.P01.Interfaces.Drink;
import L06Solid.Exercise.P01.Interfaces.Product;

public class Coke implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;
    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    @Override
    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCaloriesPer100Grams() {
        return CALORIES_PER_100_GRAMS;
    }
}
