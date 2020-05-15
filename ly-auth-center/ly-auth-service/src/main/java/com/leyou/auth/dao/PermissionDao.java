package com.leyou.auth.dao;

import com.leyou.auth.entity.RoleEntity;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * 
 * @author yangchang
 * @email sunlightcs@gmail.com
 * @date 2020-05-15 11:58:35
 */
public interface PermissionDao extends Mapper<RoleEntity>, SelectByIdListMapper<RoleEntity, Long> {
	
}
