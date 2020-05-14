package com.leyou.shiro.config;

import com.leyou.common.utils.CookieUtils;
import com.leyou.shiro.bean.AuthShiroToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JwtAuthShiroFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String token = CookieUtils.getCookieValue((HttpServletRequest) request,"LY_TOKEN");
        //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
        if(null!=token) {
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                //token 错误
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue((HttpServletRequest) request,"LY_TOKEN");
        if(StringUtils.isBlank(token)){
            return false;
        }
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(new AuthShiroToken(token));
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }


}
