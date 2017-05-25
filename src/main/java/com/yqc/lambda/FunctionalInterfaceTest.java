package com.yqc.lambda;

import java.util.function.Function;

/**
 * Created by yangqc on 2017/5/23.
 */
public class FunctionalInterfaceTest {

    public static final int x = 1;
    public static final int y = 20;

    public int addInt(int x, int y) {
        return x - y;
    }

    public static void showCalculateResult(CalculateInterface calculateInterface) {
        calculateInterface.calculate();
    }

    public static void showParameterResult(ParameterInterface parameterInterface) {
        System.out.println(parameterInterface.showParameter(x, y));
    }

    public static void main(String[] args) {
        showCalculateResult(() -> {
            System.out.println("ÆÚ³É!");
        });

        Function<String, String> upperfier = String::toUpperCase;

        showParameterResult((x, y) -> x + y);

        showParameterResult(new FunctionalInterfaceTest()::addInt);
//        System.out.println((new FunctionalInterfaceTest()::addInt).toString);
    }
}
