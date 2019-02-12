package com.github.redis.schedule;

import com.alibaba.fastjson.JSON;
import com.github.redis.pojo.Person;
import com.github.redis.repository.PersonPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * <p>
 * 创建时间为 下午1:17-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
@EnableScheduling
public class ScheduleTask1 {

    @Autowired
    private PersonPagingAndSortingRepository repository;

//    @Scheduled(fixedRate = 1000)
    public void task() {
        Person person = getPerson();
        System.out.println(JSON.toJSONString(person));
        repository.save(person);
    }

    private static Person getPerson() {
        Random random = new Random();
        Person person = new Person();
        int data = random.nextInt(200);
        person.setId(data + "");
        person.setAge(data);
        person.setName("name:" + data);
        person.setPass("pass:" + data);
        person.setExpiration(999L);
        return person;
    }

}
