package com.ff.blog.vo.params;


import lombok.Data;

@Data
public class PageParams {


    private int page = 1;

    private int pageSize = 10;

    private Long categoryId;

    private Long tagId;

    private String year;

    private String month;

    public String getMonth(){
        return (month!=null && month.length()==1)?("0"+month):month;
    }

}