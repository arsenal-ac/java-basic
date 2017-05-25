package com.yqc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //ע���ע�� ���Ҳ٣���Ԫע��,��ע�Ᵽ�浽�����ڴ�׶�
@Target({ElementType.METHOD, ElementType.TYPE}) //ע��������ĸ�λ��
public @interface MyAnnotation {

    String color() default "blue";

    String value(); //��������

    int[] arrayAttr() default {1, 2, 3};

    MetaAnnotation annotationAttr() default @MetaAnnotation(name = "hello");

    Class a();
}
