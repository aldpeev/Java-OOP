package L01WorkingWithAbstractions.Lab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dataRectangle = readIntArr(scanner);

        Point bottomLeft = new Point(dataRectangle[0], dataRectangle[1]);
        Point topRight = new Point(dataRectangle[2], dataRectangle[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            int[] pointData = readIntArr(scanner);
            Point pointToCheck = new Point(pointData[0], pointData[1]);

            System.out.println(rectangle.contains(pointToCheck));
        }
    }

    private static int[] readIntArr(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
