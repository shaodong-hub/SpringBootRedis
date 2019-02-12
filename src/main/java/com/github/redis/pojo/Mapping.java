package com.github.redis.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 创建时间为 下午1:06-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@EqualsAndHashCode
public class Mapping {

    private String sha;

    private String[] args;

}
