package com.github.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

/**
 * <p>
 * 创建时间为 上午11:11-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class TopicConfig {

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("DataTest");
    }


}
