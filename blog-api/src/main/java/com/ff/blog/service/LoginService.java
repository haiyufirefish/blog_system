package com.ff.blog.service;

import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.LoginParams;

public interface LoginService {
    Result login(LoginParams loginParams);
}