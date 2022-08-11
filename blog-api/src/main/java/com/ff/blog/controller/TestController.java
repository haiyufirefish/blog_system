package com.ff.blog.controller;

import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.utils.UserThreadLocal;
import com.ff.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}