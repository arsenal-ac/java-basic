package com.yqc.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by yangqc on 2017/5/23.
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<String, String> function = (x) -> {
            System.out.println(x + ":");
            return "Function";
        };

        //Predicate<T> -T作为输入，返回的boolean值作为输出
        Predicate<String> pre = (x) -> {
            System.out.println(x);
            return false;
        };

        //Consumer<T>,T作为输入,执行某些动作但没有返回值
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };

        //Supplier<T> - 没有任何输入，返回T
        Supplier<String> supplier = () -> {
            return "Supplier";
        };

        System.out.println(supplier);
    }
}
