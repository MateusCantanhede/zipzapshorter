package com.cantanhede.ds.zipzapshorter.domain.core.exceptions;

public class CoreException extends Exception{
    public  CoreException(String message){
        super(message);
    }
    public  CoreException(String message, Throwable cause){
        super(message, cause);
    }
}
