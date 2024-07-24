package com.cantanhede.ds.zipzapshorter.domain.application.exceptions;

public class ApplicationException extends Exception{
    public ApplicationException(String message){
        super(message);
    }
    public ApplicationException(String message, Throwable cause){
        super(message, cause);
    }
}
