package com.z;

import com.z.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {

		stringRedisTemplate.opsForValue().set("xxx","9999");
		redisTemplate.opsForValue().set("user002", new User(10,"zhangsan", "111", "a@b.com"));
	}

}
