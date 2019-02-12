package com.github.redis.script;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.io.IOException;

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


@Component
public class ScriptHyperLogLog {

    @Autowired
    private StringRedisConnection connection;

    @Bean("HyperLogLog")
    public RedisScript script() throws IOException {
        ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("scripts/HyperLogLog.lua"));
        RedisScript script = RedisScript.of(scriptSource.getScriptAsString(), Boolean.class);
        connection.scriptLoad(script.getScriptAsString());
        return RedisScript.of(scriptSource.getScriptAsString(), Boolean.class);
    }

}
