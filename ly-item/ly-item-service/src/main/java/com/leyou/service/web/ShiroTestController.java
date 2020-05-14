package com.leyou.service.web;

import com.leyou.service.feigin.AuthClientTest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shiro")
public class ShiroTestController {

    @Autowired
    private AuthClientTest authClientTest;

    @GetMapping("add")
    @RequiresPermissions("add")
    public ResponseEntity<String> add(){
        return ResponseEntity.ok("通过");
    }

    @GetMapping("look")
    @RequiresPermissions("look")
    public ResponseEntity<String> look(){
        return ResponseEntity.ok("look通过");
    }


}
