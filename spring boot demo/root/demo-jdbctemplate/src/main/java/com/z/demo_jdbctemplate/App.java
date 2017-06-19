package com.z.demo_jdbctemplate;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agui on 2017/6/16.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BasicDataSource ds = (BasicDataSource)context.getBean("dataSource");
        ds.getConnection();
        int debug = 0;
    }

    public static List getBeans(AbstractApplicationContext context){
        List<Object> ls = new ArrayList();
        for(String n:context.getBeanDefinitionNames()){
            ls.add(context.getBean(n));
        }
        return ls;
    }
}
