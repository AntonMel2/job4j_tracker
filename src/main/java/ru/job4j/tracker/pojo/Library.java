package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("Effective Java", 1000);
        Book two = new Book("Java: A Beginner’s Guide", 720);
        Book three = new Book("Head First Java", 800);
        Book four = new Book("Clean code", 1200);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        books[0] = four;
        books[3] = one;
        System.out.println("Replace 0 to 3");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println("Shown only Clean code");
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}

