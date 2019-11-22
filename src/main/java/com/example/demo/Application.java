package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhou
 */
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        printSysInfo(run);
    }


    /**
     * 打印系统关键信息
     *
     * @author zhou
     * @date 2019-10-24 10:59
     */
    static void printSysInfo(ConfigurableApplicationContext application) throws UnknownHostException {
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n------------------------------------------------------------------------------\n\t" +
                "Application example is running! Access URLs:\n\t" +
                "Local: \t\t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \t\thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \t\thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \t\t\thttp://" + ip + ":" + port + path + "/v2/api-docs\n" +
                "------------------------------------------------------------------------------");
    }
}
