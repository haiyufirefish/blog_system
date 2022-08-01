package com.ff.blog.service;

import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.vo.Result;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface SysUserService {
//    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据账户查找用户
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);
}