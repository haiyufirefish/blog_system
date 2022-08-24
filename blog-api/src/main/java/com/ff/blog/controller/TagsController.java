package com.ff.blog.controller;

import com.ff.blog.service.TagsService;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @GetMapping("hot")
    public Result listHotTags() {
        int limit = 6;
        List<TagVo> tagVoList = tagsService.hot(limit);
        return Result.success(tagVoList);
    }

    @GetMapping
    public Result findAll(){
        return tagsService.findAll();
    }

    @GetMapping("detail")
    public Result findALLDetail(){
        return tagsService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id){
        return tagsService.findDetailbyId(id);
    }
}