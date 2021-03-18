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
        boolean ret = (row < data.length) && column < data[data.length - 1].length;
        while (ret && data[row].length == 0) {
            row++;
        }
        return ret;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int ret = data[row][column++];
        if (column > data[row].length - 1) {
            row++;
            column = 0;
        }
        return ret;
    }
}
