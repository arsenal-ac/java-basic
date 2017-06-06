package com.yqc.annotation.inherite;

import java.lang.annotation.*;

/**
 * Created by yangqc on 2017/5/25.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER})
public @interface Greeting {

    enum FontColor {BULE, RED, GREEN}

    String name();

    FontColor fontColor() default FontColor.GREEN;
}
