package com.example.EmployeeBook.Exceptions;

public class EmployeeIsNotInListException extends RuntimeException{
    public EmployeeIsNotInListException(String message){
        super(message);
    }
}