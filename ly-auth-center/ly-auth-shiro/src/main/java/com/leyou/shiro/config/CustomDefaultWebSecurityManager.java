package com.leyou.shiro.config;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 配置shiro的securitymanager器
 */
public class CustomDefaultWebSecurityManager extends DefaultWebSecurityManager implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.setRealm(applicationContext.getBean(CustomShiroReam.class));
    }
}
