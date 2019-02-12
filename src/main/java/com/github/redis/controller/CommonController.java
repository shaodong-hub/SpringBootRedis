package com.github.redis.controller;

import com.github.redis.pojo.Person;
import com.github.redis.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:23-2019/1/25
 * 项目名称 SpringBootRedis
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
public class CommonController {

    @Autowired
    private CommonService service;

    @GetMapping("person")
    public List<Person> getPersons(@PageableDefault(size = 4, page = 1, sort = "name,desc") Pageable pageable) {
        return service.getPersons(pageable);
    }

}
