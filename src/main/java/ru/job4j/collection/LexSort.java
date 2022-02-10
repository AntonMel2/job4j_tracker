package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
       String[] rslleft = left.split(". ", 2);
       String[] rslright = right.split(". ", 2);
       int l =  Integer.parseInt(rslleft[0]);
       int r = Integer.parseInt(rslright[0]);
       return Integer.compare(l, r);
    }
}
