package com.hqk.bootdemo.util;

/**
 * <p>自定义异常处理信息</p >
 *
 * @author hqk
 * @version 1.0: MyException.java v0.1 2019/6/19 上午10:55 hqk Exp$
 */
public class MyException extends RuntimeException{

    //异常状态码
    private String code;

    //异常信息
    private String message;


    public MyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
