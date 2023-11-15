package L01WorkingWithAbstractions.Exercise.P01CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String card = scanner.nextLine();
        String suit = scanner.nextLine();

        Card.printCard(card,suit);
    }
}
