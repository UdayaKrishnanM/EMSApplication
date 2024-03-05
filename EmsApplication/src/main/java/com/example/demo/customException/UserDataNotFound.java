package com.example.demo.customException;

public class UserDataNotFound extends Exception{

    public UserDataNotFound(String msg){
        super(msg);
    }

}
