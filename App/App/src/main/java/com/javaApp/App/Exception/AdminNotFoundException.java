package com.javaApp.App.Exception;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(String message){
        super(message);
    }
}
