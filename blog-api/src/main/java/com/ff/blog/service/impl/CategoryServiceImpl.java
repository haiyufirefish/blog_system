package com.ff.blog.service.impl;

import com.ff.blog.service.CatagoryService;
import com.ff.blog.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CatagoryServiceImpl implements CatagoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCatagoryById(Long id) {
        Locale.Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}