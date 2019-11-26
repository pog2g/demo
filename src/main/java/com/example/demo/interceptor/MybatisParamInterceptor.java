package com.example.demo.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

/**
 * Mybatis 查询参数拦截器
 *
 * @author zhouxuanhong
 * @date 2019-11-18 11:36
 * @since JDK1.8
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
@Slf4j
@Component
public class MybatisParamInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MetaObject metaObject = SystemMetaObject.forObject(invocation.getTarget());
        Object parameterObject = metaObject.getValue("parameterHandler.parameterObject");
        if (Objects.nonNull(parameterObject)) {
            log.debug("------------MybatisParamInterceptor------insert data------>intercept:{}", parameterObject);
        }
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object target) {
        // 只处理StatementHandler
        System.out.println("------------MybatisParamInterceptor------------>plugin:" + target.getClass());
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

