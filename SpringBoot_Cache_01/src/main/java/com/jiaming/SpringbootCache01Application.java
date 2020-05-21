package com.jiaming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一. 搭建基本环境
 *  1. 创建数据库,创建两张表`department``employee`
 *  2. 创建 JavaBean
 *  3. 整合 Mybatis,操作数据库
 *      1.配置数据源
 *      2.使用 Mybatis注解版快速操作
 *
 * 二. 使用缓存
 *  1. 开启基于注解的缓存@EnableCaching
 *  2. 使用缓存注解操作
 *      @CacheConfig
 *      @Cacheable
 *      @CachePut
 *      @CacheEvict
 *      @Caching
 *
 * 三. 整合 Redis
 *  1. 安装 Redis
 *  2. 引入Redis启动器
 *  3. 配置 Redis主机地址
 *  4. 测试缓存
 *
 */
//扫描所有 mapper
@EnableCaching //开启缓存注解
@MapperScan("com.jiaming.mapper")
@SpringBootApplication
public class SpringbootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCache01Application.class, args);
    }

}
