package com.yqc.annotation.inherite;

import java.lang.reflect.Method;

/**
 * Created by yangqc on 2017/5/25.
 */
public class GetParameterAnnotation {

    // TODO 获取注解参数的值
    public static void getParameterValue(SuperClass superClass) throws NoSuchMethodException {
        Method method = superClass.getClass().getMethod("showName", String.class);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        getParameterValue(new SuperClass());
    }
}
