package com.pp.bplat.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * <pre>
 * com.kt.prm.common.annotation
 * SessionCommand.java
 * 
 * lion web에서 bind될 session annotation
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:26:39
 * @Version : 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SessionCommand {
    boolean isNewIfAbsent() default false;
}
