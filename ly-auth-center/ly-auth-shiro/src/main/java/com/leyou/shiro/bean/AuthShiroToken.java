package com.leyou.shiro.bean;

import org.apache.shiro.authc.AuthenticationToken;

public class AuthShiroToken implements AuthenticationToken {

    private String token;


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public AuthShiroToken(String token) {
        this.token = token;
    }

    public AuthShiroToken() {
    }
}
