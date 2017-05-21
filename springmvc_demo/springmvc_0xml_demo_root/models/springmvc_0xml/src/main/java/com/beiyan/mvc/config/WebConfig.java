package com.beiyan.mvc.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;

/**
 * Spring Mvc 容器配置
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.beiyan.mvc.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setConfiguration();
//        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");

        freeMarkerConfigurer.setConfiguration(new freemarker.template.Configuration() {{
            setTemplateLoader(new MultiTemplateLoader(
                    new TemplateLoader[]{
                            new ClassTemplateLoader(WebConfig.class, "/"),
//                            new WebappTemplateLoader(servletContext, "/")
                    }
            ));
            setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
//            setStrictSyntaxMode(true);
            setWhitespaceStripping(true);
        }});

        return freeMarkerConfigurer;
    }
/*
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

    /**
     * @return
     * @Author: "白亮"
     * @Date: 2016年10月4日 下午12:50:59
     * @Title: multipartResolver
     * @Description: 文件上传解析策略
     */
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    /**
     * 启用spring mvc 的注解（不启用只能通过显示的配置）
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
