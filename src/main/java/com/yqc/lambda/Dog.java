package com.yqc.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by yangqc on 2017/5/22.
 */
@AllArgsConstructor
public class Dog {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;
}
