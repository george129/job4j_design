package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize;
    private int outSize;

    SimpleQueue() {
        this.inSize = 0;
        this.outSize = 0;
    }

    public T poll() {
        if (outSize == 0 && inSize == 0) {
                throw new NoSuchElementException();
        }
        if (outSize == 0 && inSize > 0) {
            while (inSize > 0) {
                out.push(in.pop());
                outSize++;
                inSize--;
            }
        }
        outSize--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inSize++;
    }
}
