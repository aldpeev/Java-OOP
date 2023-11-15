package L06Solid.Exercise.P01;

import L06Solid.Exercise.P01.Interfaces.Product;
import L06Solid.Exercise.P01.products.Chocolate;
import L06Solid.Exercise.P01.products.Coke;
import L06Solid.Exercise.P01.products.Lemonade;

import java.util.List;

public class CalorieCalculator {

    public static double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {

            if (product instanceof Coke) {
                double grams = ((Coke) product).getMilliliters() * Coke.DENSITY;
                sum += (product.getCaloriesPer100Grams() / 100) * grams;
            }

            if (product instanceof Lemonade) {
                double grams = ((Lemonade) product).getMilliliters() * Lemonade.DENSITY;
                sum += (product.getCaloriesPer100Grams() / 100) * grams;
            }

            if (product instanceof Chocolate) {
                sum += (product.getCaloriesPer100Grams()/ 100) * ((Chocolate) product).getGrams();
            }
        }

        return sum;
    }

    public static double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
