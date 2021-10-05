package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount;
    private int size;

    public SimpleLinkedList() {
        this.modCount = 0;
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(E value) {
        Node<E> temp = new Node<>(value);
        if (first == null) {
            first = temp;
            first.setNext(null);
            last = first;
        } else {
            last.setNext(temp);
            last = temp;
        }
        modCount++;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        int position = 0;
        while (current != null && position < index) {
            position++;
            current = current.nextNode;
        }
        return current.getData();
    }

    @Override
    public Iterator<E> iterator() {
        class SimpleListIterator implements Iterator<E> {
            private int modSnapshot;
            private Node<E> cursor;

            public SimpleListIterator() {
                modSnapshot = modCount;
                cursor = first;
            }

            @Override
            public boolean hasNext() {
                if (modSnapshot != modCount) {
                    throw new ConcurrentModificationException("Elements changed during iteration");
                }
                return cursor != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> ret = cursor;
                cursor = cursor.getNextNode();
                return ret.getData();
            }
        }
        return new SimpleListIterator();
    }

    private class Node<E> {
        private Node<E> nextNode;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNext(Node<E> next) {
            nextNode = next;
        }

        public E getData() {
            return data;
        }
    }
}
