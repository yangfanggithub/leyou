package com.leyou.shiro.annotion;

import com.leyou.shiro.config.CustomAuthorizationAttributeSourceAdvisor;
import com.leyou.shiro.config.CustomDefaultWebSecurityManager;
import com.leyou.shiro.config.CustomShiroFilterFactoryBean;
import com.leyou.shiro.config.CustomShiroReam;
import com.leyou.shiro.feign.AuthClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({CustomShiroReam.class,CustomDefaultWebSecurityManager.class,CustomShiroFilterFactoryBean.class, CustomAuthorizationAttributeSourceAdvisor.class})
@EnableFeignClients(basePackageClasses = AuthClient.class)
public @interface EnableCustomShiro {

}
