package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int position = 0;
//    private int evenCount;

    public EvenIterator(final int[] numbers) {
        data = numbers;
    }

//    private void countEven() {
//        for (int datum : data) {
//            if (datum % 2 == 0) {
//                evenCount++;
//            }
//        }
//    }

    @Override
    public boolean hasNext() {
//        if (position < data.length) {
//            if (data[position] % 2 == 0) {
//                return true;
//            } else {
//                while(position < data.length && data[position] % 2 != 0) {
//                    position++;
//                }
//            }
//        }
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
