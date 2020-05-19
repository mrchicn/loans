package com.wjl.loans.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> BaseResult<T> handle(Exception e) {
        if (e instanceof BaseException) {
            Integer code = 104;
            BaseException exception = (BaseException) e;
            if (exception.getCode() != 0) {
                code = exception.getCode();
            }
            return ResultUtil.error(code, e.getMessage());
        }
        return ResultUtil.error(500, e.getMessage() == null ? "服务器内部错误" : e.getMessage());
    }
}

