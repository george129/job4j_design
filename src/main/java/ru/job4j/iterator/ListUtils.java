package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            if (li.nextIndex() > index) {
                break;
            }
            li.next();
        }
        li.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            if (filter.test(li.next())) {
                li.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            if (filter.test(li.next())) {
                li.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            T tmp = li.next();
            for (T element : elements) {
                if (tmp == element) {
                    li.remove();
                    break;
                }
            }
        }
    }

}
