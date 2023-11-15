package L02Encapsulation.Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaData = readData(scanner);
            Pizza pizza = createPizza(pizzaData);

            String[] doughData = readData(scanner);
            Dough dough = createDough(doughData);

            pizza.setDough(dough);

            String[] toppingData = readData(scanner);
            while (!toppingData[0].equals("END")){
                Topping currentTopping = createTopping(toppingData);

                pizza.addTopping(currentTopping);

                toppingData = readData(scanner);
            }

            System.out.printf("%s - %.2f",pizza.getName(), pizza.getOverallCalories());


        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static Topping createTopping(String[] toppingData) {
        String toppingType = toppingData[1];
        double weight = Double.parseDouble(toppingData[2]);

        return new Topping(toppingType,weight);
    }

    private static Dough createDough(String[] doughData) {
        String flourType = doughData[1];
        String backingTechnique = doughData[2];
        double weight = Double.parseDouble(doughData[3]);

        return new Dough(flourType,backingTechnique,weight);
    }

    private static Pizza createPizza (String[] pizzaData) {
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        return new Pizza(pizzaName,numberOfToppings);
    }

    private static String[] readData (Scanner scanner){
        return scanner.nextLine().split(" ");
    }
}