package com.leyou.auth.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthApi {

    /**
     * 获取当前登陆用户权限
     * @return
     */
    @GetMapping("getAuth")
    String getAuth(@RequestParam("token")String token);

    @GetMapping("logout")
    ResponseEntity<Void> logout();

}
