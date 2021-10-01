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
        if (capacity > 0 && capacity < Integer.MAX_VALUE) {
            this.container = (T[]) new Object[capacity];
            this.size = 0;
            modCount = 0;
        } else {
            throw new IndexOutOfBoundsException(capacity);
        }
    }

    private void extend() {
        int newsz;
        if (size <= Integer.MAX_VALUE * 0.666) {
            newsz = size + size / 2;
        } else {
            throw new IndexOutOfBoundsException("Indexes count exceeds MAX_VALUE of Integer");
        }
        T[] newcon = (T[]) new Object[newsz];
        System.arraycopy(container, 0, newcon, 0, size);
        container = newcon;
    }

    private void removeHole(int holeIndex) {
        if (holeIndex < size - 1) {
            System.arraycopy(container, holeIndex + 1, container, holeIndex,  size - holeIndex);
        } else if (holeIndex == size - 1) {
            container[holeIndex] = null;
            if (size > 10) {
                container = Arrays.copyOf(container, size + size >> 1);
            }
        }
        container = Arrays.copyOf(container, 2);
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
        Objects.checkIndex(index, container.length);
        container[index] = newWalue;
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return (T) container[index];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
        T removed = container[index];
        removeHole(index);
        size--;
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
                if (hasNext()) {
                    return (T) container[index++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        }
        return new SimpleArrayIterator();
    }
}