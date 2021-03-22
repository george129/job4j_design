package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int position = 0;

    public EvenIterator(final int[] numbers) {
        data = numbers;
    }

    @Override
    public boolean hasNext() {
        while (position < data.length) {
            if (data[position] % 2 == 0) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[position++];
    }
}
