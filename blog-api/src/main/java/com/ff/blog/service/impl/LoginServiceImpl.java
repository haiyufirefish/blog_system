package com.ff.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.ff.blog.dao.pojo.SysUser;
import com.ff.blog.service.LoginService;
import com.ff.blog.service.SysUserService;
import com.ff.blog.utils.JWTUtils;
import com.ff.blog.vo.ErrorCode;
import com.ff.blog.vo.Result;
import com.ff.blog.vo.params.LoginParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class LoginServiceImpl implements LoginService {

    private static final String slat = "ff!@#";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Result login(LoginParams loginParams) {
        /*
         * 1.check if the param valid
         * 2.based on user and password check if the user exists
         * 3. If not, fail
         * 4.1 If yes, using jwt to generate token, return to frontend
         * 4.2 token into redis, token: user info set the expiration date
         * 5. login verify to check in redis: two classes verification
         */
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();

        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }

        String pwd = DigestUtils.md5Hex(password + slat);
        SysUser sysUser = sysUserService.findUser(account,pwd);


        if(sysUser == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }

        String token = JWTUtils.createToken(sysUser.getId());
        // put into redis
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }
}