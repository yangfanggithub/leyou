package com.leyou.gateway.filter;

import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.utils.CookieUtils;
import com.leyou.gateway.properties.FilterProperties;
import com.leyou.gateway.properties.JwtProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bystander
 * @date 2018/10/2
 */
@Slf4j
@Component
@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})
public class LoginFilter extends ZuulFilter {

    @Autowired
    private JwtProperties props;

    @Autowired
    private FilterProperties filterProps;

    /**
     * 过滤器类型 pre route post error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序 返回值越小 优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 5;
    }

    /**
     * 是否执行该过滤器（run方法）
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        //判断白名单（跳过某些不需要过滤的url）
        return !isAllowPath(requestURI);
    }

    /**
     * 编写过滤器逻辑
     * @return
     */
    @Override
    public Object run() {

        //获取上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = context.getRequest();
        String token = CookieUtils.getCookieValue(request, props.getCookieName());
        try {
            //从Token获取解析用户信息
            JwtUtils.getUserInfo(props.getPublicKey(), token);
            //解析成功，什么都不做，放行

            //todo 如果做权限管理的话，在这做权限检验
        } catch (Exception e) {
            //检验出现异常，返回403
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(403);
            context.setResponseBody("no login:please login");
            log.error("非法访问，未登录，地址：{}", request.getRemoteHost(), e);
        }

        //返回值为null 表示该过滤器什么都不做
        return null;
    }

    /**
     * 判断请求URI是不是白名单中的URI
     *
     * @param requestURI
     * @return
     */
    private Boolean isAllowPath(String requestURI) {
        boolean flag = false;

        for (String allowPath : filterProps.getAllowPaths()) {
            if (requestURI.startsWith(allowPath)) {
                //允许
                flag = true;
                break;
            }
        }
        return flag;


    }



}
