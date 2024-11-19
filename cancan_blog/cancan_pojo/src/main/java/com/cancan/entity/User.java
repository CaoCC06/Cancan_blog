package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName user
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
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
    * 密码
    */
    private String password;
    /**
    * 身份 0：管理员 1：普通成员
    */
    private String identity;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 性别 0：男，1：女，2：保密
    */
    private String sex;
    /**
    * 常驻省份
    */
    private String province;
    /**
    * 密保问题与答案
    */
    private String problemOfPassword;
    /**
    * 状态 0：禁用，1：启用
    */
    private Integer status;
    /**
    * 逻辑删除 0：未删除 1：删除
    */
    private Integer deleted;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
}
