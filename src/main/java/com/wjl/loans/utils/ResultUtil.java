package com.wjl.loans.utils;

import com.wjl.loans.utils.BaseResult;

import java.util.Random;

public class ResultUtil {

    public static <T> BaseResult<T> success(String successMsg, T data) {
        return commonResult(100, 200, successMsg, data);
    }


    public static <T> BaseResult<T> error(String errorMsg, T data) {
        return commonResult(-100, -316, errorMsg, data);
    }


    public static <T> BaseResult<T> error(Integer code, String errorMsg) {
        return commonResult(0, code, errorMsg, null);
    }

    private static <T> BaseResult<T> commonResult(Integer status, Integer code, String errMsg, T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(errMsg);
        result.setData(data);
        return result;
    }
}
