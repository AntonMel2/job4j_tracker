package ru.job4j.oop;

public class Usage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane1();
        Vehicle train = new Train1();
        Vehicle bus = new Bus1();
        Vehicle airplane2 = new Airplane1();
        Vehicle train2 = new Train1();
        Vehicle bus2 = new Bus1();

        Vehicle[] vehicles = new Vehicle[] {airplane, train, bus, train2, airplane2, bus2};
        for (Vehicle y : vehicles) {
            y.move();
        }
    }
}
