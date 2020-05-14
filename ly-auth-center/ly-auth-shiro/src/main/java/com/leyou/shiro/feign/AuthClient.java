package com.leyou.shiro.feign;

import com.leyou.auth.api.AuthApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("auth-service")
public interface AuthClient extends AuthApi {

}
