package com.dragonfly.timemachine.util.jpa;

/**
 * Created by Arun on 9/4/2015.
 */
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Inherited
@Target(TYPE)
@Retention(RUNTIME)
public @interface IdAssigned {
    boolean value() default true;
}
