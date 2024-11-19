package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName hole
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 内容
    */
    private String content;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 是否可见 0：可见 1：不可见
    */
    private Integer visible;
    /**
    * 逻辑删除 0：未删除 1：删除
    */
    private Integer deleted;
}
