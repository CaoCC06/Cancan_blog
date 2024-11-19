package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName article
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 文章标题
    */
    private String title;
    /**
    * 文章链接
    */
    private String content;
    /**
    * 是否可见 0：可见 1：不可见
    */
    private Integer visible;
    /**
    * 逻辑删除 0：未删除 1：删除
    */
    private Integer deleted;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新&操作时间
    */
    private LocalDateTime updateTime;
}
