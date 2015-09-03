package com.bplat.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SessionCommand {
    boolean isNewIfAbsent() default false;
}
