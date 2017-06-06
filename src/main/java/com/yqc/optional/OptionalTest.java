package com.yqc.optional;

import java.util.Optional;

/**
 * Created by yangqc on 2017/6/6.
 */
public class OptionalTest {

    public static void main(String[] args) {
        //of��ͨ��������������Optional��,�����Ĳ�������Ϊnull
        //�������Ϊnull,���׳�NullPointerException
        Optional<String> name = Optional.of("Nicholas");
        Optional<String> someNull = Optional.of(null);

        //Ϊָ����ֵ����һ��Optional,���ָ����ֵΪnull,�򷵻�һ���յ�Optional
        Optional empty = Optional.ofNullable(null);

        //isPresent�����������Optional�������Ƿ����ֵ
        if (name.isPresent()) {
            //��Optionalʵ���ڵ���get()�����Ѵ��ڵ�ֵ
            //get����,���Optional�����򽫷���,�����׳�NoSuchElementException
            System.out.println("name is " + name.get());
        }

        //���ֵ��Ϊnull��orElse��������Optionalʵ����ֵ.
        //���Ϊnull�����ش������Ϣ.
        //�����There is no value present!
        System.out.println(empty.orElse("There is no value present!"));
        //�����Sanaulla
        System.out.println(name.orElse("There is some value!"));
    }
}
