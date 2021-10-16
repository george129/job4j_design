package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import ru.job4j.generics.SimpleArray;
import ru.job4j.list.List;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private List<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> itr = set.iterator();
        while (itr.hasNext()) {
            if (Objects.equals(itr.next(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
