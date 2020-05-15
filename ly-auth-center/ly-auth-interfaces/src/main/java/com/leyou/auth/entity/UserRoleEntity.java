package com.leyou.auth.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * 
 * @author yangchang
 * @email sunlightcs@gmail.com
 * @date 2020-05-15 11:58:34
 */
@Data
@Table(name="tb_user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 角色id
	 */
	private String roleId;

}
