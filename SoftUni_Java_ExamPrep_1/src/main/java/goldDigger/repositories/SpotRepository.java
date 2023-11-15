package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.*;

public class SpotRepository<T> implements Repository<T>{
    private Collection<T> spots;

    public SpotRepository() {
        spots = new ArrayList<>();
    }


    @Override
    public Collection<T> getCollection() {
        return null;
    }

    @Override
    public void add(T entity) {

    }

    @Override
    public boolean remove(T entity) {
        return false;
    }

    @Override
    public T byName(String name) {
        return null;
    }
}
