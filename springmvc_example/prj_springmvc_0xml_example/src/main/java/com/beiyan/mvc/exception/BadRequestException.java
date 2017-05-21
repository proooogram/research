package com.beiyan.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义坏请求异常
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "自定义Test异常")
public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }
}
