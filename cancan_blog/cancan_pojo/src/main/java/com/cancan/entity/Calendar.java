package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName calendar
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calendar implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 日期
    */
    private LocalDateTime date;
    /**
    * 逻辑删除 0：未删除 1：删除
    */
    private Integer deleted;
    /**
    * 是否可见 0：可见 1：不可见
    */
    private Integer visible;
}
