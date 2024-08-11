package com.Database.Practicedemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlarClass {

    @ExceptionHandler(MyClassException.class)
    public ResponseEntity<ApiResponse> resoureNotFoundException(MyClassException ex){

        String msg = ex.getMessage();

        ApiResponse apiResponse = new ApiResponse(msg,false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);


    }
}
