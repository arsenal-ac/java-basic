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

        //Predicate<T> -T��Ϊ���룬���ص�booleanֵ��Ϊ���
        Predicate<String> pre = (x) -> {
            System.out.println(x);
            return false;
        };

        //Consumer<T>,T��Ϊ����,ִ��ĳЩ������û�з���ֵ
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };

        //Supplier<T> - û���κ����룬����T
        Supplier<String> supplier = () -> {
            return "Supplier";
        };

        System.out.println(supplier);
    }
}
