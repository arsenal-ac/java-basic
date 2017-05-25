package com.yqc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解的注解 ，我操，叫元注解,将注解保存到加入内存阶段
@Target({ElementType.METHOD, ElementType.TYPE}) //注解可用于哪个位置
public @interface MyAnnotation {

    String color() default "blue";

    String value(); //特殊属性

    int[] arrayAttr() default {1, 2, 3};

    MetaAnnotation annotationAttr() default @MetaAnnotation(name = "hello");

    Class a();
}
