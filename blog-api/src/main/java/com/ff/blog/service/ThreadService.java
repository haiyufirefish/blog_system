package com.ff.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ff.blog.dao.mapper.ArticleMapper;
import com.ff.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateViewCount(ArticleMapper articleMapper, Article article){
        Article articleupdate = new Article();
        articleupdate.setViewCounts(article.getViewCounts()+1);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,article.getId());
        queryWrapper.eq(Article::getViewCounts,article.getViewCounts());
        articleMapper.update(articleupdate,queryWrapper);

        try {
            Thread.sleep(5000);
            System.out.printf("update finishing");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}