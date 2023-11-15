package L04InterfacesAndAbstraction.Exercise.P02FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Buyer> buyerMap = new LinkedHashMap<>();

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        while (numOfPeople -- > 0){
            String[] buyerData = scanner.nextLine().split(" ");

            String name = buyerData[0];
            int age = Integer.parseInt(buyerData[1]);

            Buyer currentBuyer;

            if (buyerData.length == 4){
                String id = buyerData[2];
                String birthDate = buyerData[3];

                currentBuyer = new Citizen(name,age,id,birthDate);
            } else {
                String group = buyerData[2];

                currentBuyer = new Rebel(name,age,group);
            }

            buyerMap.putIfAbsent(name, currentBuyer);
        }

        String name = scanner.nextLine();
        while (!name.equals("End")){

            if (buyerMap.containsKey(name)){
                buyerMap.get(name).buyFood();
            }

            name = scanner.nextLine();
        }

        System.out.println(buyerMap.values().stream().map(Buyer::getFood).mapToInt(Integer::intValue).sum());
    }
}
