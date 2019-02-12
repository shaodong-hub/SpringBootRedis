package com.github.redis.listener;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午4:23-2019/1/30
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Component
public class ReceivingMessages{

    public void receiveMessage(String message){
        System.out.println(message);
    }

}
