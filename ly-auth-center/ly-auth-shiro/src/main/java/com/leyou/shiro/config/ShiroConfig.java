package com.leyou.shiro.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //自定义realm域
    @Bean
    public CustomShiroReam customShiroReam(){
        return new CustomShiroReam();
    }

    //shiro的security管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(CustomShiroReam customShiroReam){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customShiroReam);
        return defaultWebSecurityManager;
    }

    //配置shiro支持注解类
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //shiro默认配置
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        // 自定义 OAuth2Filter 过滤器（整合jwt），替代默认的过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", new JwtAuthShiroFilter());
        shiroFilterFactoryBean.setFilters(filters);
        //配置拦截链 使用LinkedHashMap,因为LinkedHashMap是有序的，shiro会根据添加的顺序进行拦截
        // Map<K,V> K指的是拦截的url V值的是该url是否拦截
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>(16);
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问,先配置anon再配置authc。
        //filterChainMap.put("/login","anon");
        //所有路径都必须经过jwt过滤器筛选
        filterChainMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        //设置拦截请求后跳转的URL.
        shiroFilterFactoryBean.setLoginUrl("http://api.leyou.com/api/auth/accredit");
        return shiroFilterFactoryBean;
    }

}
