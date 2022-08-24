package com.ff.blog.dao.mapper;

//import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ff.blog.dao.dos.Archives;
import com.ff.blog.dao.pojo.Article;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface ArticleMapper extends BaseMapper<Article>{

    List<Archives> listArchives();

    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);

}