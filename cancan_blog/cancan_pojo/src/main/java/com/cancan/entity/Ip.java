package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName ip
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ip implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Integer id;
    /**
    * 访问者IP
    */
    private String ip;
    /**
    * 访问时间
    */
    private LocalDateTime time;
}
