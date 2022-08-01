package com.ff.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ff.blog.dao.pojo.Tag;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long articleId);
    List<Tag> findTagsByTagIds(List<Long> tagIds);
    List<Long> findHotsTagIds(int limit);
}