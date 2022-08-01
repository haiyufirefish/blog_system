package com.ff.blog.dao.mapper;

//import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ff.blog.dao.dos.Archives;
import com.ff.blog.dao.pojo.Article;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface ArticleMapper extends BaseMapper<Article>{

    List<Archives> listArchives();
}