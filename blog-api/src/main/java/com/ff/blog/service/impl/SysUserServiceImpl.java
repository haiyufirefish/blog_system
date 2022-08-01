package com.ff.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ff.blog.dao.mapper.SysUserMapper;
import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.service.SysUserService;
import com.ff.blog.vo.Result;

public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        return null;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.eq(SysUser::getPassword,password);

        queryWrapper.select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname);
        queryWrapper.last("limit 1");

        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        return null;
    }

    @Override
    public SysUser findUserByAccount(String account) {
        return null;
    }

    @Override
    public void save(SysUser sysUser) {

    }
}