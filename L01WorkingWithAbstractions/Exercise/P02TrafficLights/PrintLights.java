package L01WorkingWithAbstractions.Exercise.P02TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintLights {

    public static void PrintLights(String[] initialState, int rows) {
        List<TrafficLight> listTrafficLights = Arrays.stream(TrafficLight.values()).collect(Collectors.toList());

        int startingIndex = listTrafficLights.indexOf(TrafficLight.valueOf(initialState[initialState.length - 1]));
        int cols = initialState.length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(listTrafficLights.get(startingIndex) + " ");
                startingIndex++;
                if (startingIndex >= listTrafficLights.size()){
                    startingIndex = 0;
                }
            }
            System.out.println();
        }
    }
}
