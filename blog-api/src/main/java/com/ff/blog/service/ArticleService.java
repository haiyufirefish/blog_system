package com.ff.blog.service;

import com.ff.blog.vo.ArticleVo;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.ArticleParam;
import com.ff.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    Result listArticles(PageParams pageParams);
    Result hotArticle(int limit);
    Result newArticles(int limit);

    Result listArchives();

    ArticleVo findArticleById(Long id);

    Result publish(ArticleParam articleParam);
}