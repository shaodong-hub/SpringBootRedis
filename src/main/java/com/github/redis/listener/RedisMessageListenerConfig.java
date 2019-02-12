package com.github.redis.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * <p>
 * 创建时间为 下午4:22-2019/1/30
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Configuration
public class RedisMessageListenerConfig {

    private static String topicName = "DataTest";

    @Bean
    public RedisMessageListenerContainer getContainer(RedisConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(connectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic(topicName));
        return redisMessageListenerContainer;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(ReceivingMessages recevier) {
        return new MessageListenerAdapter(recevier, "receiveMessage");
    }


}