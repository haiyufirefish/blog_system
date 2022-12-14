package com.ff.blog.controller;

import com.ff.blog.service.SysUserService;
import com.ff.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("currentUser")
    public Result CurrentUser(@RequestHeader("Authorization")String token){
        return sysUserService.getUserInfoByToken(token);
    }
}