package com.jiaming.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author jmstart
 * @create 2020-05-18 9:37
 *
 * 缓存配置类
 *  自己定义一个主键生成策略
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {

        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "["+ Arrays.asList(objects).toString() +"]";
            }
        };

    }
}
