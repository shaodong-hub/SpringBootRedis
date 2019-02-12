package com.github.redis.controller;

import com.github.redis.pojo.Person;
import com.github.redis.service.ReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 创建时间为 上午10:21-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class ReactiveController {

    @Autowired
    private ReactiveService service;

    @PostMapping("rsave")
    public Mono<Boolean> postPerson(@RequestBody Person person) {
        return service.save(person);
    }




}
