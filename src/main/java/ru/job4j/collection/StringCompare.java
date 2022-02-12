package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Integer.compare(left.length(), right.length()) > 0 ? left.length() : right.length();
        for (int i = 0; i < minSize; i++) {
           int rsl = Character.compare(left.charAt(i), right.charAt(i));
           if (rsl != 0) {
               return rsl;
           } else {
               return Integer.compare(left.length(), right.length());
           }
        }
        return Integer.compare(left.length(), right.length());
    }
}
