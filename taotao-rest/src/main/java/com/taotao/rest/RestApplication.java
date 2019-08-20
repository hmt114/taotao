package com.taotao.rest;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hmt
 * @date 2019/7/31 21:42
 */
@SpringBootApplication
@MapperScan("com.taotao.mapper")
@EnableDubbo(scanBasePackages = "com.taotao.rest.service.Impl")
public class
RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class,args);
    }
}
