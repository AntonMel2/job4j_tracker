package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> fName = (p) -> p.getName().contains(key);
        Predicate<Person> fSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> fPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> fAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> nameOrSur = fName.or(fSurname);
        Predicate<Person> phoneOrAddress = fPhone.or(fAddress);
        Predicate<Person> combine = nameOrSur.or(phoneOrAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
