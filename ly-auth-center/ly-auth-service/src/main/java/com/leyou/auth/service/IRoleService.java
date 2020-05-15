package com.leyou.auth.service;


import com.leyou.auth.entity.RoleEntity;
import com.leyou.common.vo.PageResult;

public interface IRoleService {

    PageResult<RoleEntity> selectAllPage(Integer page, Integer rows,String sortBy,boolean desc, String name);

    int addRole(RoleEntity role);

    void delete(int roleId);

}
