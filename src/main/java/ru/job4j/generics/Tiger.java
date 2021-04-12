package ru.job4j.generics;

public class Tiger extends Predator {
    private static int counter = 0;

    public Tiger() {
        counter++;
    }

    @Override
    public String toString() {
        return "Tiger #" + counter;
    }

}
