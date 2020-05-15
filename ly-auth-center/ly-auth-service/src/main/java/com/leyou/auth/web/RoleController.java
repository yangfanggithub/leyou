package com.leyou.auth.web;

import com.leyou.auth.entity.RoleEntity;
import com.leyou.auth.service.IRoleService;
import com.leyou.common.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") boolean desc,
            @RequestParam(value = "name",required = false) String name
    ){
        PageResult<RoleEntity> entityPageResult = roleService.selectAllPage(rows, page, sortBy, desc, name);
        return ResponseEntity.ok(entityPageResult);
    }

    @PostMapping
    public ResponseEntity<Void> addRole(RoleEntity role){
        int id = roleService.addRole(role);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable("roleId") int roleId){
        roleService.delete(roleId);
        return ResponseEntity.ok().build();
    }

}
