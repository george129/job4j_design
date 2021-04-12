package ru.job4j.generics;

public class Animal {
    private static int counter = 0;

    public Animal() {
        counter++;
    }

    @Override
    public String toString() {
        return "Animal #" + counter;
    }
}
