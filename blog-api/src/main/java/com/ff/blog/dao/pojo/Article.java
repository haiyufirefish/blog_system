package com.ff.blog.dao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String summary;

//    private Integer commentCounts; it needs to use Integer rather than int
    private int commentCounts;

    private Integer viewCounts;

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
    private Integer weight;


    /**
     * create time
     */
    private Long createDate;
}