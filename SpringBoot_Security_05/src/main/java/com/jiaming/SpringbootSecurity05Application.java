package com.jiaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 引入SpringSecurity启动器
 * 2. 编写SpringSecurity配置类
 * 3. 控制请求的访问权限
 */
@SpringBootApplication
public class SpringbootSecurity05Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurity05Application.class, args);
    }

}
