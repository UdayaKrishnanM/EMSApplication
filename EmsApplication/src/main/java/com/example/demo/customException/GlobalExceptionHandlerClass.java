package com.example.demo.customException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import java.util.Date;


public class GlobalExceptionHandlerClass {



    @ExceptionHandler(UserDataNotFound.class)
    public ResponseEntity<ErrorCodes> customexceptionhandler(UserDataNotFound e){
        ErrorCodes error = new ErrorCodes();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(new Date());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
