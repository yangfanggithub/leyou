package com.leyou.auth.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.auth.dao.RoleDao;
import com.leyou.auth.entity.RoleEntity;
import com.leyou.auth.service.IRoleService;
import com.leyou.common.utils.UuidUtils;
import com.leyou.common.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public PageResult<RoleEntity> selectAllPage(Integer page, Integer rows,String sortBy,boolean desc, String name) {
        PageHelper.startPage(rows,page);
        Example example=new Example(RoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if (StringUtils.isNotBlank(sortBy)) {
            String sortByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(sortByClause);
        }
        List<RoleEntity> roleEntities = roleDao.selectByExample(example);
        PageInfo<RoleEntity> pageInfo = new PageInfo<>(roleEntities);
        return new PageResult<>(pageInfo.getTotal(), roleEntities);
    }

    @Override
    public int addRole(RoleEntity role) {
        role.setRoleId(UuidUtils.getUUID32());
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        return roleDao.insert(role);
    }

    @Override
    public void delete(int roleId) {
        int row = roleDao.deleteByPrimaryKey(roleId);
    }

}
