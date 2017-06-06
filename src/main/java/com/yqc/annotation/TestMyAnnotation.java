package com.yqc.annotation;

/**
 * 自己定义注解
 *
 * @author Yangqc
 *         2015.10.19
 */
@MyAnnotation(value = "abc", arrayAttr = {1, 1}, annotationAttr = @MetaAnnotation(name = "你好"), a = String.class)
public class TestMyAnnotation {

}
