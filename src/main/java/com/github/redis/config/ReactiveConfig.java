package com.github.redis.config;

import com.github.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 * 创建时间为 上午10:10-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ReactiveConfig {

    @Autowired
    private ReactiveRedisConnectionFactory factory;


    @Bean
    public ReactiveRedisTemplate<String, Person> getReactiveRedisTemplate() {
        // JdkSerializationRedisSerializer
        Jackson2JsonRedisSerializer<Person> serializer = new Jackson2JsonRedisSerializer<>(Person.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Person> builder = RedisSerializationContext
            .newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, Person> serializationContext = builder.value(serializer).build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }

}
