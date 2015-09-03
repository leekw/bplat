package com.bplat.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MetadataRequest {
    String key() default "params";
    Class  listClass() default Object.class;
    boolean required() default true;
}