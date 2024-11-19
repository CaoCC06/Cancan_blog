package com.cancan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* 
* @TableName article_keyword
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleKeyword implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 关键字id
    */
    private Long keywordId;
    /**
    * 文章id
    */
    private Long articleId;
}
