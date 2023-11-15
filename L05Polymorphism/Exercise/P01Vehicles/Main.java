package L05Polymorphism.Exercise.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);
        Vehicle bus = getVehicle(scanner);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] vehicleData = scanner.nextLine().split(" ");

            String command = vehicleData[0];
            String vehicleType = vehicleData[1];
            double argument = Double.parseDouble(vehicleData[2]);

            switch (command) {

                case "Drive":
                    vehicleMap.get(vehicleType).drive(argument);
                    break;
                case "Refuel":
                    vehicleMap.get(vehicleType).refuel(argument);
                    break;
                case "DriveEmpty":
                    Vehicle busVehicle = vehicleMap.get(vehicleType);
                    if (busVehicle instanceof Bus) {
                        Bus buss = (Bus) busVehicle;
                        buss.emptyBusConsumption();
                    }

                    vehicleMap.get(vehicleType).drive(argument);
                    break;
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    public static Vehicle getVehicle(Scanner scanner) {
        String[] data = scanner.nextLine().split(" ");

        double fuel = Double.parseDouble(data[1]);
        double consumption = Double.parseDouble(data[2]);
        double tankCapacity = Double.parseDouble(data[3]);

        switch (data[0]) {
            case "Car":
                return new Car(fuel, consumption, tankCapacity);
            case "Truck":
                return new Truck(fuel, consumption, tankCapacity);
            case "Bus":
                return new Bus(fuel, consumption, tankCapacity);
            default:
                throw new IllegalArgumentException("Invalid Vehicle");
        }
    }
}
