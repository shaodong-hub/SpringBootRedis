package com.github.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 * 创建时间为 下午12:59-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class StringRedisConnectionConfig {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public StringRedisConnection getStringRedisConnection() {
        final AtomicReference<StringRedisConnection> redisConnection = new AtomicReference<>();
        stringRedisTemplate.execute((RedisCallback<Object>) connection -> {
            redisConnection.set((StringRedisConnection) connection);
            return null;
        });
        return redisConnection.get();
    }



}
