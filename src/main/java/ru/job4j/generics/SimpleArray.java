/*
Создать класс:
public class SimpleArrayList<T>
Добавить методы:
add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;
set(int index, T model) - заменяет указанным элементом (model) элемент, находящийся по индексу index;
remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
get(int index) - возвращает элемент, расположенный по указанному индексу;
Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.
Объект должен принимать количество ячеек. Структура не должна быть динамической.

Примечание:
1. В методах, где используется индекс нужно делать валидацию. Индекс должен находиться в рамках добавленных элементов. Например, у вас есть хранилище из 10 элементов. Вы добавили 3 элемента. Каким может быть индекс? [0, 2]. Для проверки индекса используйте метод Objects.checkIndex().
Этот метод используется для проверки того, находится ли индекс в пределах заданной длины. Он возвращает индекс, если 0 <= index < length. В противном случае генерируется исключение IndexOutOfBoundsException.
Обрабатывать исключение не нужно! Т.к. это связано не с нашей ошибкой, а с ошибкой пользователя нашего класса
Objects.checkIndex(index, size);
// Далее ваша логика
2. Не путать null элементы и пустые ячейки контейнера. Список может содержать null элементы.
3. Для удаления использовать System.arraycopy() вместо цикла
*/

package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int size;

    public SimpleArray() {
        size = 0;
        array = new Object[10];
    }

    public SimpleArray(int n) {
        if (n > 0 && n <= Integer.MAX_VALUE) {
            size = 0;
            array = new Object[n];
        } else {
            throw new ArrayStoreException("Too much elements");
        }
    }

    private void extend() {
        int newsize = 0;
        if (array.length <= Integer.MAX_VALUE * 0.66) {
            newsize = array.length + (array.length >> 1);
        } else {
            throw new ArrayIndexOutOfBoundsException("Too much elements");
        }
        Object[] newArray = new Object[newsize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void compress(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index);
        } else if (index == size - 1) {
            array[index] = null;
            if (size > 10) {
                array = Arrays.copyOf(array, size + size >> 1);
            }
        }
    }

    public void add(T model) {
        if (array.length < size + 5) {
            extend();
        }
        array[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    /*
    Objects.checkIndex() - для проверки, находится ли индекс в пределах заданной длины.
    Возвращает индекс, если 0 <= index < length, иначе генерирует исключение IndexOutOfBoundsException.
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        compress(index);
        size--;
    }

    T get(int index) {
        return (T) array[index];
    }

    int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIter implements Iterator<T> {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return (T) array[index++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        }
        return new SimpleArrayIter();
    }
}
