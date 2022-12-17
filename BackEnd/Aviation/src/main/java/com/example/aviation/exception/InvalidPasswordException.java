package com.example.aviation.exception;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidPasswordException(String message){
        super(message);
    }
}
