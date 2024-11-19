package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* 
* @TableName keyword
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 关键字
    */
    private String keyword;
    /**
    * 逻辑删除 0：未删除 1：删除
    */
    private Integer deleted;
    /**
    * 是否可见 0：可见 1：不可见
    */
    private Integer visible;
}
