package com.junkj.common.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

import com.junkj.common.mybatis.query.QueryType;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

	String name() default "";

	String sql() default "";

	String attrName() default "";

	String comment() default "";

	String label() default "";

	boolean isPK() default false;

	boolean isQuery() default true;

	boolean isInsert() default true;

	boolean isUpdate() default true;

	boolean isUpdateForce() default false;

	boolean isTreeName() default false;

	QueryType queryType() default QueryType.EQ;

	JdbcType jdbcType() default JdbcType.UNDEFINED;

	Class<?> javaType() default void.class;

	Class<?> includeEntity() default Class.class;

	@SuppressWarnings("rawtypes")
	Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;
}
