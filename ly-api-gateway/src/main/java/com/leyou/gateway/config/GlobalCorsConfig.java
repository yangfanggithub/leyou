package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 使用CORS，用于解决ajax跨域访问问题
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter(){

        //初始化配置对象
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        corsConfiguration.addAllowedOrigin("http://www.leyou.com");
        corsConfiguration.addAllowedOrigin("http://api.leyou.com");
        //corsConfiguration.addAllowedOrigin("*");
        //2) 是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //3) 允许的请求方式
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        corsConfiguration.setMaxAge(3600L);
        // 4）允许的头信息
        corsConfiguration.addAllowedHeader("*");
        //初始化配置源对象
        UrlBasedCorsConfigurationSource configurationSource=new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",corsConfiguration);

        // 返回corsFilter实例 配置cors允许跨域信息
        return new CorsFilter(configurationSource);
    }


}