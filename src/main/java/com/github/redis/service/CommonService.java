package com.github.redis.service;

import com.github.redis.pojo.Person;
import com.github.redis.repository.PersonPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:24-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class CommonService {

    @Autowired
    private PersonPagingAndSortingRepository repository;

    public List<Person> getPersons(Pageable pageable) {
        Page<Person> page = repository.findAll(pageable);
        return page.getContent();
    }


}
