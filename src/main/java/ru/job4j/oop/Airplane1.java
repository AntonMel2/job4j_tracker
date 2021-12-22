package ru.job4j.oop;

public class Airplane1 implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }
}
