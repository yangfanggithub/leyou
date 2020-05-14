package com.leyou.shiro.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 配置shiro注解适配器
 */
public class CustomAuthorizationAttributeSourceAdvisor extends AuthorizationAttributeSourceAdvisor implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.setSecurityManager(applicationContext.getBean(CustomDefaultWebSecurityManager.class));
    }
}
