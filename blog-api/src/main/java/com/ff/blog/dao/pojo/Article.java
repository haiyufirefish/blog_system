package com.ff.blog.dao.pojo;

import lombok.Data;

@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    /**
     * author id
     */
    private Long authorId;
    /**
     * content id
     */
    private Long bodyId;
    /**
     * category type
     */
    private Long categoryId;

    /**
     * set top
     */
    private int weight = Article_Common;


    /**
     * create time
     */
    private Long createDate;
}