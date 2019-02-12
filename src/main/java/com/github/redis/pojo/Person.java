package com.github.redis.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 上午10:02-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@RedisHash("people")
public class Person implements Serializable {

    private static final long serialVersionUID = -6543195003290304307L;

    @Id
    @Indexed
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String pass;

    @Indexed
    private Integer age;

    @TimeToLive
    private Long expiration;

}
