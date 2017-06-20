package com.z.controller;

import com.z.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agui on 2017/6/16.
 */
@RestController
public class HelloController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplateSO;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/hello")
    public String hello(){
        return "hello!this is response";
    }

    @RequestMapping("/redis_set_user03")
    public String redis_set_user03(){
        redisTemplateSO.opsForValue().set("user03", new User(10,"user03", "lisi", "z@z.com"));
        return "ok";
    }

    @RequestMapping("/redis_get_user03")
    public String redis_get_user03(){
        Object obj = redisTemplateSO.opsForValue().get("user03");
        User user03 = (User) obj;
        return user03.toString();
    }


}
