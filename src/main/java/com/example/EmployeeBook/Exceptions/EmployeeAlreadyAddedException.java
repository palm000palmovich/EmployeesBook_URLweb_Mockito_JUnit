package com.example.EmployeeBook.Exceptions;

public class EmployeeAlreadyAddedException extends  RuntimeException{
    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}