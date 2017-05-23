package com.yqc.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by yangqc on 2017/5/23.
 */
public class PredicateTest {

    /**
     * showNames使用Predicate
     *
     * @param names
     */
    public void showNames(List<String> names) {
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        Consumer<String> consumer = (n) -> System.out.println(n);
        if (names != null && names.size() > 0) {
            //Predicate使用了and逻辑
            names.stream().filter(startsWithJ.and(fourLetterLong)).forEach(consumer);
        }
    }

    public static void main(String[] args) {
    }
}
