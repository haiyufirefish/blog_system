package com.ff.blog.service.impl;

import com.ff.blog.dao.mapper.SysUserMapper;
import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long userId) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("ff");
        }
        return sysUser;
    }
}