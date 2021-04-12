package ru.job4j.generics;

public class Predator extends Animal {
    private static int counter = 0;

    public Predator() {
        counter++;
    }

    @Override
    public String toString() {
        return "Predator #" + counter;
    }
}
