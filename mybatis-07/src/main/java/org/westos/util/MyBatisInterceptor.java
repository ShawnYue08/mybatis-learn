package org.westos.util;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author lwj
 * @date 2020/9/20 9:17
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyBatisInterceptor implements Interceptor {
    /*
    * MyBatis允许拦截
    * 1、Executor执行器（SqlSession持有执行器）
    * 2、SQL语句执行 StatementHandler 拦截sql语句
    * 3、参数
    * 4、结果
    * (1)需要用@Intercepts注解来指定
    * (2)将该拦截器注册到mybatis-config.xml
    * */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler sh = (StatementHandler) invocation.getTarget();
        MetaObject mo = SystemMetaObject.forObject(sh);
        //获得了运算后的sql
        Object value = mo.getValue("delegate.boundSql.sql");
        System.out.println("MyBatisInterceptor-->>" + value);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
