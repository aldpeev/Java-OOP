package L06Solid.Exercise.P01;

import L06Solid.Exercise.P01.CalorieCalculator;
import L06Solid.Exercise.P01.Interfaces.Product;

import java.util.List;

public class Printer {

    public static void printSumCalories (List<Product> products){
        System.out.printf("Sum of all calories: %.2f%n",CalorieCalculator.sum(products));
    }

    public static void printAverageCalories(List<Product> products){
        System.out.printf("Average calories of all products: %.2f%n", CalorieCalculator.average(products));
    }

}
