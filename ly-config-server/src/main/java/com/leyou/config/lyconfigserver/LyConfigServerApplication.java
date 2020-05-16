package com.leyou.config.lyconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootConfiguration
@EnableAutoConfiguration
public class LyConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyConfigServerApplication.class, args);
    }

}
