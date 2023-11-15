package L01WorkingWithAbstractions.Lab.P03HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(data[0]);
        int days = Integer.parseInt(data[1]);
        String season = data[2];
        String discount = data[3];

        System.out.printf("%.2f", PriceCalculator.calculate(pricePerDay,days,season,discount));
    }
}
