package com.leyou.auth.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.auth.dao.RoleDao;
import com.leyou.auth.entity.RoleEntity;
import com.leyou.auth.service.IRoleService;
import com.leyou.common.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public PageResult<RoleEntity> selectAllPage(Integer page, Integer rows, String name) {
        PageHelper.startPage(page,rows);
        Example example=new Example(RoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        List<RoleEntity> roleEntities = roleDao.selectByExample(example);
        PageInfo<RoleEntity> pageInfo = new PageInfo<>(roleEntities);
        return new PageResult<>(pageInfo.getTotal(), roleEntities);
    }

}
