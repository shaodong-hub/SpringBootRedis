package com.github.redis.dao;

import com.github.redis.pojo.Mapping;
import com.github.redis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 上午11:08-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class CommonDao {

    @Autowired
    private RedisTemplate<String, Person> template;

    public List<Long> getResult(Set<Mapping> set) {
        List<Object> results = template.executePipelined((RedisCallback<Object>) connection -> {
            StringRedisConnection redisConnection = (StringRedisConnection) connection;
            set.forEach(one -> redisConnection.evalSha(one.getSha(), ReturnType.INTEGER, 1, one.getArgs()));
            return redisConnection;
        });
        return results.stream().map(Long.class::cast).collect(Collectors.toList());
    }


}
