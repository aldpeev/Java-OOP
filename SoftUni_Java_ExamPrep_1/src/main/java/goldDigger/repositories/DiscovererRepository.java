package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DiscovererRepository<T> implements Repository<T>{
    private Collection<T> discoverers;

    public DiscovererRepository() {
        discoverers = new ArrayList<>();
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
