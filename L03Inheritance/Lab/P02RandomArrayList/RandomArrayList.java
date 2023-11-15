package L03Inheritance.Lab.P02RandomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList <T> extends ArrayList<T> {

    public Object getRandomElement(){
        Random rnd = new Random();

        int randomIndex = ThreadLocalRandom.current().nextInt(0, size());

        Object randomEl = get(randomIndex);

        remove(randomIndex);

        return randomEl;
    }

}
