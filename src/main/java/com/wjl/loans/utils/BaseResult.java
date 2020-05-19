package com.wjl.loans.utils;

/**
 *  返回统一的格式
 * @param <T>
 */
public class BaseResult<T> {

    private Integer code;

    private Integer status;

    private String msg;

    private T data;

    public BaseResult() {
    }

    public BaseResult(Integer code, Integer status, String msg, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
