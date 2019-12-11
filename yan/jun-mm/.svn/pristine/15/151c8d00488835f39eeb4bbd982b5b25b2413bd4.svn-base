package com.junkj.common.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface Table {

	String name() default "";

	String comment() default "";

	String alias() default "a";
	
	String orderBy() default "";

	Column[] columns() default {};
	
	JoinTable[] joinTable() default {};

	String sql() default "";
}
