package com.z.controller;

import com.z.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agui on 2017/6/16.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/ua")
    public String ua(){
        return userRepository.findAll().get(0).getUsername();
    }
}
