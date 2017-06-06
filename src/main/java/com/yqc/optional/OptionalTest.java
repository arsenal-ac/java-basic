package com.yqc.optional;

import java.util.Optional;

/**
 * Created by yangqc on 2017/6/6.
 */
public class OptionalTest {

    public static void main(String[] args) {
        //of是通过工厂方法创建Optional类,创建的参数不能为null
        //如果参数为null,则抛出NullPointerException
        Optional<String> name = Optional.of("Nicholas");
        Optional<String> someNull = Optional.of(null);

        //为指定的值创建一个Optional,如果指定的值为null,则返回一个空的Optional
        Optional empty = Optional.ofNullable(null);

        //isPresent方法用来检查Optional视力中是否包含值
        if (name.isPresent()) {
            //在Optional实例内调用get()返回已存在的值
            //get方法,如果Optional幼稚则将返回,否则抛出NoSuchElementException
            System.out.println("name is " + name.get());
        }

        //如果值不为null，orElse方法返回Optional实例的值.
        //如果为null，返回传入的消息.
        //输出：There is no value present!
        System.out.println(empty.orElse("There is no value present!"));
        //输出：Sanaulla
        System.out.println(name.orElse("There is some value!"));
    }
}
