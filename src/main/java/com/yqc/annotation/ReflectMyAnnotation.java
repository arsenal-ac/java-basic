package com.yqc.annotation;

/**
 * ����Ƿ���ע��
 *
 * @author Administrator
 */
public class ReflectMyAnnotation {
    public static void main(String[] args) {
        if (TestMyAonnotion.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = TestMyAonnotion.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
//			MyAnnotation annotation=annotation.annotationAttr();
            System.out.println(annotation.annotationAttr().name());
        }
    }
}
