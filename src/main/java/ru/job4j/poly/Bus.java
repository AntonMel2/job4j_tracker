package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("go");
    }

    @Override
    public void passengers(int pass) {
        System.out.println(pass);
    }

    @Override
    public double refuel(double fuel) {
        return 50 * fuel;
    }
}
