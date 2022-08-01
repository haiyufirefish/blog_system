package com.ff.blog.service;

import com.ff.blog.vo.ArticleVo;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> listArticlesPage(PageParams pageParams);
    Result hotArticle(int limit);
    Result newArticles(int limit);

    Result listArchives();
}