package com.z.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agui on 2017/6/16.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello!this is response";
    }
}
