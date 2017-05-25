package com.yqc.annotation.inherite;

/**
 * Created by yangqc on 2017/5/25.
 */
public class ChildClass extends SuperClass {

    public static void main(String[] args) {
        Greeting greeting = ChildClass.class.getAnnotation(Greeting.class);
        if (greeting != null) {
            System.out.println(greeting.name());
        }
    }
}
