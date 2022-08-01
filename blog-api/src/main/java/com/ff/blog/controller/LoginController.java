package com.ff.blog.controller;

import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.service.LoginService;
import com.ff.blog.service.SysUserService;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

//    @Autowired    It is not recommended, as one service is for one function
//    private SysUserService sysUserService;

    @Autowired
    private LoginService loginServivce;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return loginServivce.login(loginParams);
    }
}