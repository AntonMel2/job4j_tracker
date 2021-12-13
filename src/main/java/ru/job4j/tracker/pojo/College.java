package ru.job4j.tracker.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Anton Ivanov");
        student.setGroup("MB2-2");
        student.setDate("09.12.2021");
        System.out.println(student.getFio() + " group: " + student.getGroup() + "," + " date: " + student.getDate());
    }
}
