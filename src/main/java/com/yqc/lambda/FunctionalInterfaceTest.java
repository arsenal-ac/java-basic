package com.yqc.lambda;

/**
 * Created by yangqc on 2017/5/23.
 */
public class FunctionalInterfaceTest {

    public static void showCalculateResult(CalculateInterface calculateInterface) {
        calculateInterface.calculate();
    }

    public static void main(String[] args) {
        showCalculateResult(() -> {
            System.out.println("ÆÚ³É!");
        });
    }
}
