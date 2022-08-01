package com.ff.blog.handler;


import com.ff.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody // return json
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-999,"System Exception");
    }

}