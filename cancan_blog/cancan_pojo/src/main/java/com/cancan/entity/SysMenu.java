package com.cancan.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 菜单表
* @TableName sys_menu
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    *
    */
    private Long id;
    /**
    * 菜单名
    */
    private String menuname;
    /**
    * 路由地址
    */
    private String path;
    /**
    * 组件路径
    */
    private String component;
    /**
    * 菜单状态(0显示1隐藏)
    */
    private String visible;
    /**
    * 菜单状态(0正常1停用)
    */
    private String status;
    /**
    * 权限标识
    */
    private String perms;
    /**
    * 菜单图标
    */
    private String icon;
    /**
    * 
    */
    private Long createBy;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private Long updateBy;
    /**
    * 
    */
    private Date updateTime;
    /**
    * 是否删除(0未删除1己删除)
    */
    private Integer delFlag;
    /**
    * 备注
    */
    private String remark;
}
