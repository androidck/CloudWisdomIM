package com.cloundwisdom.im.common.base;

/**
 * 统一数据格式
 * @param <T>
 */
public class BaseResponse<T> {

    private int code;

    private String msg;

    private T newslist;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }

}
