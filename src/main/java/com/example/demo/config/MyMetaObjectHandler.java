package com.example.demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 自定义填充公共字段处理类
 *
 * @author zhou
 * @date 2019-04-03 18:12
 * @since JDK1.8
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动注入创建信息
        Object createTime = getFieldValByName("createTime", metaObject);
        if (createTime == null) {
            this.setInsertFieldValByName("createTime", new Date(), metaObject);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
    }
}