package com.junkj.common.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface JoinTable {

	Type type() default Type.JOIN;

	Class<?> entity() default Object.class;

	String attrName() default "";

	String alias();

	String on();

	Column[] columns() default {};

	public enum Type {
		LEFT_JOIN, JOIN, RIGHT_JOIN
	}

}
