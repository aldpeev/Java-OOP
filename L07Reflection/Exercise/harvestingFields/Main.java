package L07Reflection.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		String input = scanner.nextLine();
		while (!input.equals("HARVEST")){
			switch (input){
				case "private":
					break;
				case "protected":
					break;
				case "public":
					break;
				case "all":
					for (Field declaredField : richSoilLandClass.getDeclaredFields()) {
						
					}


					break;

			}

			input = scanner.nextLine();
		}

	}
}
