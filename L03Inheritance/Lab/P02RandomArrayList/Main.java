package L03Inheritance.Lab.P02RandomArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<String> rndList = new RandomArrayList<>();

        rndList.add("Pesho");
        rndList.add("Gosho");
        rndList.add("Mosho");

        System.out.println(rndList.getRandomElement());

    }
}
