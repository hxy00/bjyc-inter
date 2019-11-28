package com.bjyc.inter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @Auther: Mr.Huang
 * @Date: 2019/5/15 15:36
 * @Description:
 */
@SpringBootApplication
public class BjycInterApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BjycInterApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BjycInterApplication.class);
    }

//    @Bean
//    public Filter bjycInterFilter() {
//        return new BjycInterFilter();
//    }
}
