package com.ff.blog.service;

import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.CommentParam;

public interface CommentsService {

    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}