package com.leyou.service.feigin;

import com.leyou.auth.api.AuthApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("auth-service")
public interface AuthClientTest extends AuthApi {
}
