package com.cancan.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @TableName sys_role_menu
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;
}
