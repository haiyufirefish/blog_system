package com.ff.blog.controller;

import com.ff.blog.service.ArticleService;
import com.ff.blog.vo.ArticleVo;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * Homepage article
     * @param pageParams
     * @return
     */
    @PostMapping
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo page receive the data

//        int i = 10/0;
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);

        return Result.success(articles);
    }

    @PostMapping("hot")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("new")
    public Result newArticles(){
        int limit = 3;
        return articleService.newArticles(limit);
    }

    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

}