package L02Encapsulation.Exercise.P03ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        List<Person> personList = fillListPerson(people);
        List<Product> productList = fillListProduct(products);

        String command = scanner.nextLine();
        while(!command.equals("END")){
            String[] data = command.split(" ");

            String personsName = data[0];
            String productType = data[1];

            personBuyingProduct(personList, productList, personsName, productType);

            command = scanner.nextLine();
        }

        for (Person person : personList) {
            System.out.println(person);
        }
    }

    private static void personBuyingProduct(List<Person> personList, List<Product> productList, String personsName, String productType) {
        for (Person person : personList) {
            if (person.getName().equals(personsName)){
                for (Product product : productList) {
                    if (product.getName().equals(productType)){
                        person.buyProduct(product);
                    }
                }
            }
        }
    }

    private static List<Person> fillListPerson(String[] data) {
        List<Person> personList = new ArrayList<>();

        try {
            for (String record : data) {
                String[] recordNameAndMoney = record.split("=");

                String name = recordNameAndMoney[0];
                double money = Double.parseDouble(recordNameAndMoney[1]);

               Person person = new Person(name, money);
               personList.add(person);
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        return personList;
    }

    private static List<Product> fillListProduct(String[] data) {
        List<Product> productList = new ArrayList<>();

        try {
            for (String record : data) {
                String[] recordNameAndMoney = record.split("=");

                String name = recordNameAndMoney[0];
                double money = Double.parseDouble(recordNameAndMoney[1]);

                Product product = new Product(name, money);
                productList.add(product);
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        return productList;
    }
}
