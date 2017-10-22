package com.yqc.jdbc;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author yangqc
 * @Date 2017/7/23
 */
public class ModelClass {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private Date time;
}
