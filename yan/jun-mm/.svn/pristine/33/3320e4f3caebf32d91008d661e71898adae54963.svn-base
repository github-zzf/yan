package com.junkj.common.mybatis.interceptor;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.junkj.common.action.http.ServletUtils;
import com.junkj.common.config.Global;
import com.junkj.common.lang.ObjectUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.annotation.MyBatisDao;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }),
		@Signature(type = Executor.class, method = "query", args = { org.apache.ibatis.mapping.MappedStatement.class,
				Object.class, RowBounds.class, ResultHandler.class }) })

public class SqlInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
//		MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
//		HttpServletRequest request = ServletUtils.getRequest();
//		if (request != null) {
//			request.setAttribute(SqlCommandType.class.getName(), ms.getSqlCommandType());
//		}
//		Object result = invocation.proceed();
//		return result;
		
	    MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
	    HttpServletRequest request = ServletUtils.getRequest();
        if (request != null) {
            SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
            String s = ObjectUtils.toString(request.getAttribute(SqlCommandType.class.getName()));
            if (StrUtils.isNotBlank(s)) {
                s = new StringBuilder(s).append(",").toString();
            }
            request.setAttribute(SqlCommandType.class.getName(), new StringBuilder(s).append(sqlCommandType.toString()).toString());
        }
        return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}

}