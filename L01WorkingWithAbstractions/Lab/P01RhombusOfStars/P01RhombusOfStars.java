package L01WorkingWithAbstractions.Lab.P01RhombusOfStars;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        int n = readIntNumber();

        printRhombusOfStars(n);

    }

    private static void printRhombusOfStars(int n) {
        printUpperPart(n);
        printStars(n);
        printLowerPart(n);
    }

    private static void printLowerPart(int n) {
        int stars = n - 1;
        int spaces = 1;
        while (spaces < n) {
            printSpaces(spaces);
            printStars(stars);

            stars--;
            spaces++;
        }

    }

    private static void printUpperPart(int n) {
        int stars = 1;
        int spaces = n - 1;
        while (stars < n) {
            printSpaces(spaces);
            printStars(stars);

            stars++;
            spaces--;
        }
    }

    private static void printStars(int stars) {
        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printSpaces(int spaces) {
        for (int j = 0; j < spaces; j++) {
            System.out.print(" ");
        }
    }

    public static int readIntNumber() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
