package com.beiyan.mvc.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beiyan.mvc.exception.BadRequestException;

/**
 * 全局异常处理类，捕捉Controller中抛出的TestException异常，返回给客户端handle信息
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody String handleTestException() {
        return "handle the exception successful!";
    }

}
