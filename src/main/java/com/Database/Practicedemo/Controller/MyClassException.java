package com.Database.Practicedemo.Controller;

public class MyClassException extends RuntimeException{
    public MyClassException(String unableToFetchTheRecords) {
        super(unableToFetchTheRecords);
    }

    public MyClassException() {
        super();
    }
}
