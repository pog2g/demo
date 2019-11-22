package com.example.demo.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusConfig配置
 *
 * @author zhou
 * @since JDK1.8
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisConfiguration mybatisConfiguration() {
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        // 日志打印(只在测试环境)
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        return mybatisConfiguration;
    }


    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MyMetaObjectHandler();
    }

}
