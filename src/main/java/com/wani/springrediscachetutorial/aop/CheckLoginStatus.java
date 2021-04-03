package com.wani.springrediscachetutorial.aop;

import com.wani.springrediscachetutorial.common.UserLevel;

import javax.persistence.Inheritance;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckLoginStatus {

    UserLevel auth() default UserLevel.USER;
}
