package com.ff.blog.service;

import com.ff.blog.vo.CategoryVo;
import com.ff.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long id);

    Result findAll();
}