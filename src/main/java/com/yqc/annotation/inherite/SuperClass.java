package com.yqc.annotation.inherite;

/**
 * Created by yangqc on 2017/5/25.
 */
@Greeting(name = "qicheng")
public class SuperClass {

    public void showName(@Greeting(name = "Nicholas") String name) {
        System.out.println(name);
    }
}
