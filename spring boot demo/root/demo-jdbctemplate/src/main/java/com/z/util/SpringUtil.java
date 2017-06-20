package com.z.util;

import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proooogram on 2017/6/19.
 */
public class SpringUtil {
    public static List getBeans(AbstractApplicationContext context){
        List<Object> ls = new ArrayList();
        for(String n:context.getBeanDefinitionNames()){
            ls.add(context.getBean(n));
        }
        return ls;
    }
}
