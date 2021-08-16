package com.satan.bookmanager.model.exception;

/**
 * @author: Satan
 * @description: 登录异常
 * @date: 2021-08-11 12:18
 **/
public class LoginRegisterException extends RuntimeException {

    public LoginRegisterException(){
        super();
    }

    public LoginRegisterException(String message){
        super(message);
    }

    public LoginRegisterException(String message,Throwable cause){
        super(message, cause);
    }

    public LoginRegisterException(Throwable cause){
        super(cause);
    }


}
