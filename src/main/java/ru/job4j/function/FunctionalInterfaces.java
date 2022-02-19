package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> map.put(s, s1);
        int i = 1;
        for (String num : list) {
            biCon.accept(i++, num);
        }
        BiPredicate<Integer, String> biPred = (s, s1) -> s % 2 == 0 || map.get(s).length() == 4;
        for (Integer index : map.keySet()) {
            if (biPred.test(index, map.get(index))) {
                System.out.println("key: " + index + " value: " + map.get(index));
            }
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : sup.get()) {
            con.accept(func.apply(s));
        }
    }
}
