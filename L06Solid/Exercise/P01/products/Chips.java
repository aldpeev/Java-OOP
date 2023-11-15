package L06Solid.Exercise.P01.products;

import L06Solid.Exercise.P01.Interfaces.Food;
import L06Solid.Exercise.P01.Interfaces.Product;

public class Chips implements Product, Food {

    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    @Override
    public double getGrams() {
        return grams;
    }

    @Override
    public double getCaloriesPer100Grams() {
        return 0;
    }
}
