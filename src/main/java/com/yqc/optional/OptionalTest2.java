package com.yqc.optional;

import java.util.Optional;

/**
 * Created by yangqc on 2017/6/6.
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        Optional<String> empty = Optional.ofNullable(null);
        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        Optional<String> name = Optional.of("yangqc");
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName);

        // 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional.
        // flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional.
        // 调用结束时，flatMap不会对结果用Optional封装。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//输出yangqc

        //filter 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional.
        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaulla

        //另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }
}

class ValueAbsentException extends Throwable {

    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}
