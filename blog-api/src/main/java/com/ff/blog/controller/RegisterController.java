package com.ff.blog.controller;

import com.ff.blog.service.RegisterService;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams){
            return registerService.register(loginParams);
    }
}