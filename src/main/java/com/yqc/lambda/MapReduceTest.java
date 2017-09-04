package com.yqc.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapReduceTest {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> doubleNumer = numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        final Optional<Integer> sum = numbers.stream().filter(number -> number > 0).reduce((a, b) -> a + b);
        int result = sum.orElseGet(() -> 0);
        System.out.println("****" + result);
        System.out.println(sum.get());
        final Integer sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum2);

        final List<Integer> allNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };
        String optional = allNumbers.stream().map(function).reduce("", (a, b) -> a + "," + b);
        Optional<String> optional1 = allNumbers.stream().map(function).reduce((a, b) -> a + "," + b);
        System.out.println(optional);
        System.out.println(optional1.orElseGet(() -> "nothing"));
    }
}
