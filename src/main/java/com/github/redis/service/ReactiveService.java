package com.github.redis.service;

import com.github.redis.dao.ReactiveDao;
import com.github.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 创建时间为 上午10:22-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class ReactiveService {

    @Autowired
    private ReactiveDao reactiveDao;

    public Mono<Boolean> save(Person person) {
        return reactiveDao.save(person);
    }

}
