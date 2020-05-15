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
@Table(name = "tb_permission")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	/**
	 * 权限id
	 */
	private String permissionId;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 权限描述
	 */
	private String description;
	/**
	 * 父级权限id
	 */
	private Integer parentId;
	/**
	 * 类型 0：目录 1：按钮
	 */
	private Integer type;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 状态：1有效；2删除
	 */
	private Integer status;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
