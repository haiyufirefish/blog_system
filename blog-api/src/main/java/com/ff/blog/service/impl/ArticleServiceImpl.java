package com.ff.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.ff.blog.dao.dos.Archives;
import com.ff.blog.dao.mapper.ArticleMapper;
import com.ff.blog.dao.pojo.Article;
import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.service.ArticleService;
import com.ff.blog.service.SysUserService;
import com.ff.blog.service.TagsService;
import com.ff.blog.vo.ArticleVo;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.TagVo;
import com.ff.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
//    @Resource
//    private SysUserService sysUserService;
    @Autowired
    private TagsService tagsService;

    public ArticleVo copy(Article article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
//        if (isAuthor) {
//            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
//            articleVo.setAuthor(sysUser.getNickname());
//        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTags){
            List<TagVo> tags = tagsService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article,isAuthor,isBody,isTags);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }


    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleVo> articleVoList = copyList(articlePage.getRecords(),true,false,true);
        return articleVoList;
    }

    @Override
    public Result hotArticle(int limit) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        // select id,title from article order by view_counts desc limit 5
        return Result.success(copyList(articles,false,false,false));

    }

    @Override
    public Result newArticles(int limit) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        // select id,title from article order by view_counts desc limit 5
        return Result.success(copyList(articles,false,false,false));

    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList = articleMapper.listArchives();
        return Result.success(archivesList);
    }


}