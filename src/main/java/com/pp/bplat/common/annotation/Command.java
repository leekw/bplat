package com.pp.bplat.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * <pre>
 * com.kt.prm.common.annotation
 * Command.java
 * 
 * client 와 server 간에 bind data annotation
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:26:31
 * @Version : 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String key();
    Class  listClass() default Object.class;
    boolean required() default true;
}
