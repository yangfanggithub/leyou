package com.leyou.auth.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author yangchang
 * @email sunlightcs@gmail.com
 * @date 2020-05-15 11:58:35
 */
@Data
@Table(name = "tb_role")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色描述
	 */
	private String description;
	/**
	 * 状态：1有效；2删除
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
