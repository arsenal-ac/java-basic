package com.yqc.lambda;

/**
 * Created by yangqc on 2017/5/23.
 */
public class FunctionalInterfaceTest {

    public static final int x = 1;
    public static final int y = 20;

    public static void showCalculateResult(CalculateInterface calculateInterface) {
        calculateInterface.calculate();
    }

    public static void showParameterResult(ParameterInterface parameterInterface) {
        System.out.println(parameterInterface.showParameter(1, 20));
    }

    public static void main(String[] args) {
        showCalculateResult(() -> {
            System.out.println("ÆÚ³É!");
        });

        showParameterResult((x, y) -> x + y);
    }
}
