package com.ff.blog.common.cache;

import com.baomidou.mybatisplus.annotation.TableId;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1*60*1000;
    // cache identifier
    String name() default "";
}