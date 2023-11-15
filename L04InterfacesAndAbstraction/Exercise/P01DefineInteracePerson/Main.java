package L04InterfacesAndAbstraction.Exercise.P01DefineInteracePerson;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] data = command.split(" ");

            String typeOfObject = data[0];

            if (typeOfObject.equals("Citizen")){
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String id = data[3];
                String birthDate = data[4];

                Birthable currentCitizen = new Citizen(name,age,id,birthDate);
                birthables.add(currentCitizen);

            } else if (typeOfObject.equals("Pet")){
                String name = data[1];
                String birthDate = data[2];

                Birthable currentPet = new Pet(name,birthDate);
                birthables.add(currentPet);
            }

            command = scanner.nextLine();
        }

        String date = scanner.nextLine();

        birthables.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(date)).forEach(System.out::println);
    }


}
