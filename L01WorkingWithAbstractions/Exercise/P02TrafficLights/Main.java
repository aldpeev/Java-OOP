package L01WorkingWithAbstractions.Exercise.P02TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialState = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(scanner.nextLine());

        PrintLights.PrintLights(initialState,rows);

    }
}
