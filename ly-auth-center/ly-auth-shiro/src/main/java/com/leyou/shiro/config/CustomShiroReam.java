package com.leyou.shiro.config;

import com.leyou.auth.api.AuthApi;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomShiroReam extends AuthorizingRealm {

    private String token;

    @Autowired
    private AuthApi authApi;

    @Override
    public boolean supports(AuthenticationToken token) {
        return true;
    }
    /*
       做授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //查询所有角色
        Set<String> role=new HashSet<>();
        //查询当前用户所拥有的权限
        String getAuth = authApi.getAuth(token);
        role.add(getAuth);
        //设置角色
        authorizationInfo.setRoles(role);
        //添加权限
        authorizationInfo.addStringPermissions(Arrays.asList("add"));
        return authorizationInfo;
    }

     /*
     做验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        this.token=(String) authenticationToken.getPrincipal();
        //jwt做登陆验证
        return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),authenticationToken.getPrincipal(),"customShiroReam");
    }

}
