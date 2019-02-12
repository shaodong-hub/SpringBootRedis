package com.github.redis.repository;

import com.github.redis.pojo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>
 * 创建时间为 上午10:05-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


public interface PersonPagingAndSortingRepository extends PagingAndSortingRepository<Person, String> {


}
