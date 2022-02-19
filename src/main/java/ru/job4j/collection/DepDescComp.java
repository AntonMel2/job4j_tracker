package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1fel = o1.split("/")[0];
        String o2fel = o2.split("/")[0];
        int rsl = o2fel.compareTo(o1fel);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
