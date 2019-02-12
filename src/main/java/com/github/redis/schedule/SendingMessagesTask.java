package com.github.redis.schedule;

import com.github.redis.pojo.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午4:15-2019/1/30
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class SendingMessagesTask {

    private final RedisTemplate<String, Person> redisTemplate;

    public SendingMessagesTask(RedisTemplate<String, Person> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void task() {
        redisTemplate.convertAndSend("DataTest", getPerson());
        redisTemplate.getClientList().forEach(one -> System.out.println(one.getAddressPort()));
    }

    private static Person getPerson() {
        Person person = new Person();
        person.setId("test-id");
        person.setPass("test-name");
        person.setPass("test-pass");
        person.setAge(123);
        person.setExpiration(System.currentTimeMillis());
        return person;
    }

}
