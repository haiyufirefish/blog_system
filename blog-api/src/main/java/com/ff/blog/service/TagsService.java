package com.ff.blog.service;

import com.ff.blog.vo.Result;
import com.ff.blog.vo.TagVo;
import java.util.List;

public interface TagsService {

    List<TagVo> findTagsByArticleId(Long id);
    List<TagVo> hot(int limit);

    Result findAll();
    Result findAllDetail();

    Result findDetailbyId(Long id);
}