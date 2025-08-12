package com.saas.springbootlogin.exception;

import com.saas.springbootlogin.utils.Result;
import org.slf4j. Logger;
import org.slf4j. LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation. ExceptionHandler;
import org.springframework.web.bind.annotation. ResponseBody;

import javax.servlet.http. HttpServletRequest;

@ControllerAdvice (basePackages=" com.saas.controller")
public class GlobalExceptionHandler<HttpServletRequest>{
        private static final Logger log = LoggerFactory. getLogger (GlobalExceptionHandler.class);
        //异常处理@ExceptionHandler，主要用于Exception
        @ExceptionHandler (Exception.class)
        @ResponseBody
        public Result efror (HttpServletRequest request,Exception e){
            log.error("異常信息：",e);
            return Result.error("系統異常");
    }

        @ExceptionHandler (CustomException.class)
        @ResponseBody
        public Result customError (HttpServletRequest request, CustomException e) {
            return Result.error(e.getMsg());
        }
}