package com.yqc.annotation;

/**
 * �Լ�����ע��
 *
 * @author Yangqc
 *         2015.10.19
 */
@MyAnnotation(value = "abc", arrayAttr = {1, 1}, annotationAttr = @MetaAnnotation(name = "���"), a = String.class)
public class TestMyAnnotation {

}
