package com.wei.retrofitdemo.request;

/**
 * Created by wei on 2016/10/31.
 */
public class MyException extends Exception {
    private String message;
    private String code;

    public MyException() {
    }

    public MyException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
