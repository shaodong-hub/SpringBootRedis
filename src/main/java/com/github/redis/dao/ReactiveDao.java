package com.github.redis.dao;

import com.github.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 创建时间为 上午10:24-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class ReactiveDao {

    @Autowired
    private ReactiveRedisTemplate<String, Person> template;

    public Mono<Boolean> save(Person person) {
        return template.opsForValue().set(person.getId(), person);
    }


    public Flux<Long> reactiveScript() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setLocation(new ClassPathResource("scripts/HyperLogLog.lua"));
        script.setResultType(Long.class);
        return template.execute(script);

    }


}
