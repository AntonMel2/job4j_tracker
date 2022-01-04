package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getName().contains(key) || result.get(i).getSurname().contains(key) || result.get(i).getPhone().contains(key) || result.get(i).getAddress().contains(key)) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        System.out.println(phones);
    }
}
