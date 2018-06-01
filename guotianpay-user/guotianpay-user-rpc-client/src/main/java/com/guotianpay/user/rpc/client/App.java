package com.guotianpay.user.rpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(App.class,args);
    }
}
