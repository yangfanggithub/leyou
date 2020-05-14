package com.leyou.service;

import com.leyou.shiro.annotion.EnableCustomShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author bystander
 * @date 2018/9/13
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.leyou.service.mapper")
@EnableCustomShiro
public class LyItemService {

    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class);
    }
}
