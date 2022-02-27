package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
           int sum = add(
                    () -> {
                        int total = 0;
                        for (int i = 0; i < number.length; i++) {
                            int num = number[i];
                             total += num;
                        }
                        return total;
                    });
        System.out.println(sum);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}


