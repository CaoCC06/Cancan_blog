package com.cancan.entity;

import java.io.Serializable;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 用户表
* @TableName sys_user
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * 密码
    */
    private String password;
    /**
    * 账号状态(0正常1停用)
    */
    private String status;
    /**
    * 手机号
    */
    private String phoneNumber;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 用户类型(0管理员，1普通用户)
    */
    private String userType;
    /**
    * 创建人的用户id
    */
    private Long createBy;
    /**
    * 创时间
    */
    private Date createTime;
    /**
    * 更新人
    */
    private Long updateBy;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 删除标志(0代表未删除，1代表已删除)
    */
    private Integer delFlag;
}
