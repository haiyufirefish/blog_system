package com.ff.blog.controller;

import com.ff.blog.common.aop.LogAnnotation;
import com.ff.blog.common.cache.Cache;
import com.ff.blog.dao.pojo.Article;
import com.ff.blog.service.ArticleService;
import com.ff.blog.vo.ArticleVo;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.ArticleParam;
import com.ff.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    //add this annotation, to record the information of this interface
    @LogAnnotation(module = "article",operator = "get the article list")
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo page receive the data

//        int i = 10/0;
        Result articles = articleService.listArticles(pageParams);

        return articles;
    }

    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
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

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id")Long id){
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }

}