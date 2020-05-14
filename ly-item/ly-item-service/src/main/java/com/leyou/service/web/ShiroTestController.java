package com.leyou.service.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shiro")
public class ShiroTestController {

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
