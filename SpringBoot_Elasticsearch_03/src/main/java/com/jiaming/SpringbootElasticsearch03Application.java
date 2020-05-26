package com.jiaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术和ES交互
 *  1. Jest
 *  2. SpringData Elasticsearch
 */
@SpringBootApplication
public class SpringbootElasticsearch03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearch03Application.class, args);
    }

}
