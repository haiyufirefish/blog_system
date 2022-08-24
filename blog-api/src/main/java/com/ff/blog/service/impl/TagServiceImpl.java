package com.ff.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ff.blog.dao.mapper.TagMapper;
import com.ff.blog.dao.pojo.Tag;
import com.ff.blog.service.TagsService;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagsService {

    @Resource
    private TagMapper tagMapper;

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public List<TagVo> hot(int limit) {
        /**
         * 1. which tag has most articles, which is most hot tag
         */
        List<Long> hotsTagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(hotsTagIds)){
            return Collections.emptyList();
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(hotsTagIds);
        return copyList(tagList);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag>lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Tag::getId,Tag::getTagName);
        List<Tag> tags = this.tagMapper.selectList(lambdaQueryWrapper);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tags = this.tagMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(tags));
    }

    @Override
    public Result findDetailbyId(Long id) {
        Tag tag = tagMapper.selectById(id);
        TagVo copy = copy(tag);
        return Result.success(copy);
    }


}