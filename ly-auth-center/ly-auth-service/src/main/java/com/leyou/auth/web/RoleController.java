package com.leyou.auth.web;

import com.leyou.auth.entity.RoleEntity;
import com.leyou.auth.service.IRoleService;
import com.leyou.common.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/all/page")
    public ResponseEntity<PageResult<RoleEntity>> queryAllPage(
            @RequestParam("rows") int rows,
            @RequestParam("page")int page,
            @RequestParam(value = "name",required = false) String name
    ){
        PageResult<RoleEntity> entityPageResult = roleService.selectAllPage(rows, page, name);
        return ResponseEntity.ok(entityPageResult);
    }


}
