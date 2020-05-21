package com.jiaming.config;

import com.jiaming.bean.Employee;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * @author jmstart
 * @create 2020-05-19 10:58
 */
@Configuration
public class MyRedisConfig {

    @Bean //下面这个方法可以去RedisAutoConfiguration类中去复制
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //就加了下列二句代码
        //创建一个序列化器,下面两个序列化器都可以使用
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        //GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        //放置序列化器
        template.setDefaultSerializer(serializer);

        return template;
    }

    @Bean //自定义RedisCacheManager,适用于所有的缓存数据
    public RedisCacheManager empRedisCacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration cacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofDays(1))
                        .disableCachingNullValues()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair
                                .fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();
    }

}
