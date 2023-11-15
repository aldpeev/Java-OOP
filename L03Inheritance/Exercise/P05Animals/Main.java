package L03Inheritance.Exercise.P05Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Beast!")){
            String typeOfAnimal = command;
            String[] dataAnimal = scanner.nextLine().split(" ");

            String name = dataAnimal[0];
            int age = Integer.parseInt(dataAnimal[1]);
            String gender = dataAnimal[2];

            Animal currentAnimal;
            try{
                switch (typeOfAnimal){
                    case "Dog":
                        currentAnimal = new Dog(name,age,gender);
                        break;
                    case "Cat":
                        currentAnimal = new Cat(name,age,gender);
                        break;
                    case "Frog":
                        currentAnimal = new Frog(name,age,gender);
                        break;
                    case "Kittens":
                        currentAnimal = new Kitten(name,age);
                        break;
                    case "Tomcat":
                        currentAnimal = new Tomcat(name,age);
                        break;
                    default:
                        throw new IllegalArgumentException("Empty object");
                }

                animals.add(currentAnimal);

            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            command = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }
}
