package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements ru.job4j.list.List<T> {
    private T[] container;
    private int modCount;
    private int size;


    public SimpleArrayList() {
        container = (T[]) new Object[10];
        size = 0;
        modCount = 0;
    }

    public SimpleArrayList(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException(capacity);
        }
        this.container = (T[]) new Object[capacity];
        this.size = 0;
        modCount = 0;
    }

    /**
     *
        if (size > Integer.MAX_VALUE * 0.666) {
        throw new IndexOutOfBoundsException("Indexes count exceeds MAX_VALUE of Integer");
    }
     */
    private void extend() {
        container = Arrays.copyOf(container, size * 2);
    }

    private void removeHole(int holeIndex) {
        if (holeIndex == size - 1) {
            container[holeIndex] = null;
        } else {
            System.arraycopy(container, holeIndex + 1, container, holeIndex,  size - holeIndex);
        }
    }

    @Override
    public void add(T model) {
        if (size == container.length) {
            extend();
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public T set(int index, T newWalue) {
        Objects.checkIndex(index, size);
        container[index] = newWalue;
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removed = container[index];
        removeHole(index);
        size--;
        modCount++;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator implements Iterator<T> {
            private int index;
            private int snapshot;

            public SimpleArrayIterator() {
                this.snapshot = modCount;
            }

            @Override
            public boolean hasNext() {
                if (snapshot != modCount) {
                    throw new ConcurrentModificationException("Elements changed during iteration");
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[index++];
            }
        }
        return new SimpleArrayIterator();
    }
}