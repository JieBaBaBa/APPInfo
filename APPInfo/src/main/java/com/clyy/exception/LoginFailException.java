package com.clyy.exception;

/**
 * 登陆失败异常
 */
public class LoginFailException extends RuntimeException {

    public LoginFailException() {

    }

    public LoginFailException(String message) {
        super(message);
    }

    public LoginFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailException(Throwable cause) {
        super(cause);
    }

    protected LoginFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
