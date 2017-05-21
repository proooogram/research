package com.beiyan.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring 容器配置
 */
@Configuration
@ComponentScan(basePackages = {"com.beiyan.mvc"})
public class RootConfig {

}
