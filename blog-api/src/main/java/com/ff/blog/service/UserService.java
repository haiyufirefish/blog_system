package com.ff.blog.service;

import com.ff.blog.dao.pojo.SysUser;

public interface UserService {
    SysUser findUserById(Long userId);
}