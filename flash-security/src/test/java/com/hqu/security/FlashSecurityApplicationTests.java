package com.hqu.security;

import com.hqu.infrastructure.domain.account.api.RemoteUserClient;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class FlashSecurityApplicationTests {
    @Autowired
    RemoteUserClient remoteUserClient;

    @Test
    void contextLoads() throws BusinessException {
        User user = remoteUserClient.getByUsername("起凡1").getData();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    @Autowired
    RedisProperties lettuceClientConfiguration;
    @Autowired
    RedisConnectionFactory connectionFactory;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void redisTest() {
        System.out.println(lettuceClientConfiguration);
        System.out.println(connectionFactory);

        redisTemplate.opsForValue().set("1",lettuceClientConfiguration);
    }
}
