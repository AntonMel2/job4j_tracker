package ru.job4j.oop;

public class Usage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane2 = new Airplane();
        Vehicle train2 = new Train();
        Vehicle bus2 = new Bus();

        Vehicle[] vehicles = new Vehicle[] {airplane, train, bus, train2, airplane2, bus2};
        for (Vehicle y : vehicles) {
            y.move();
        }
    }
}
