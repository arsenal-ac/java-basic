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

        // �����ֵ��Ϊ��ִ��mapping��������Optional���ͷ���ֵ�����򷵻ؿ�Optional.
        // flatMap��map��Funtion���������ƣ���������flatMap�е�mapper����ֵ������Optional.
        // ���ý���ʱ��flatMap����Խ����Optional��װ��
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//���yangqc

        //filter �����ֵ������������������ذ�����ֵ��Optional�����򷵻ؿ�Optional.
        //filter������������Optionֵ�Ƿ�����ĳЩ������
        //��������򷵻�ͬһ��Optionʵ�������򷵻ؿ�Optional��
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));//���Sanaulla

        //��һ��������Optionalֵ������filterָ����������
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //�����name���Ȳ���6�ַ�
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
