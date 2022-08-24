package com.ff.blog.common.cache;

import com.alibaba.fastjson.JSON;
import com.ff.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

@Aspect
@Component
@Slf4j
public class CacheAspect {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public CacheAspect(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Pointcut("@annotation(com.ff.blog.common.cache.Cache)")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        try {
            Signature signature = pjp.getSignature();
            //class name
            String className = pjp.getTarget().getClass().getSimpleName();
            //call the method
            String methodName = signature.getName();


            Class[] parameterTypes = new Class[pjp.getArgs().length];
            Object[] args = pjp.getArgs();
            // parameter
            String params = "";
            for(int i=0; i<args.length; i++) {
                if(args[i] != null) {
                    params += JSON.toJSONString(args[i]);
                    parameterTypes[i] = args[i].getClass();
                }else {
                    parameterTypes[i] = null;
                }
            }
            if (StringUtils.isNotEmpty(params)) {
                //encapsulate prevent too long key
                params = DigestUtils.md5Hex(params);
            }
            Method method = pjp.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);
            // get Cache Annotation
            Cache annotation = method.getAnnotation(Cache.class);
            //set expiration
            long expire = annotation.expire();
            //cache name
            String name = annotation.name();
            //get it from redis
            String redisKey = name + "::" + className+"::"+methodName+"::"+params;
            String redisValue = redisTemplate.opsForValue().get(redisKey);
            if (StringUtils.isNotEmpty(redisValue)){
                log.info("Run into cache~~~,{},{}",className,methodName);
                return JSON.parseObject(redisValue, Result.class);
            }
            Object proceed = pjp.proceed();
            redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(proceed), Duration.ofMillis(expire));
            log.info("Put into cache~~~ {},{}",className,methodName);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return Result.fail(-999,"system error");
    }
}