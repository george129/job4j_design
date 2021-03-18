/*
Задание.

1. Реализуйте методы next и hasNext.

Копировать двухмерный в одномерный массив не нужно. Это не верное решение.

Нужно с помощью указатель row column двигать указатель.

Добавлять новые поля в класс MatrixIt не нужно.

2. Загрузите код в репозиторий. Оставьте ссылку на коммит.

3. Переведите ответственного на Петра Арсентьева.
 */
package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] dataOuter) {
        data = dataOuter;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length ) {
            row++;
            column = 0;
        }
        return row < data.length && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
