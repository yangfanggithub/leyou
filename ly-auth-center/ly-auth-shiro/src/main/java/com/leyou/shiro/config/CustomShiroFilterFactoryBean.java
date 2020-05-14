package com.leyou.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomShiroFilterFactoryBean extends ShiroFilterFactoryBean implements ApplicationContextAware {



    public CustomShiroFilterFactoryBean(){
        super();
        //配置拦截链 使用LinkedHashMap,因为LinkedHashMap是有序的，shiro会根据添加的顺序进行拦截
        // Map<K,V> K指的是拦截的url V值的是该url是否拦截
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>(16);
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问,先配置anon再配置authc。
        //filterChainMap.put("/login","anon");
        filterChainMap.put("/**", "jwt");
        //设置拦截请求后跳转的URL.
        this.setLoginUrl("http://api.leyou.com/api/auth/accredit");
        this.setFilterChainDefinitionMap(filterChainMap);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //设置管理器
        this.setSecurityManager(applicationContext.getBean(CustomDefaultWebSecurityManager.class));
        // 自定义 OAuth2Filter 过滤器，替代默认的过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", new JwtAuthShiroFilter());
        this.setFilters(filters);
    }
}
