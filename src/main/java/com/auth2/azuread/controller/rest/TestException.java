package com.auth2.azuread.controller.rest;


import com.auth2.azuread.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TestException {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ErrorResponse> handleBusinessException(BaseException exception) {
        return this.buildResponseEntity(exception);
    }
    private ResponseEntity<ErrorResponse> buildResponseEntity(BaseException exception) {
        return new ResponseEntity(new ErrorResponse(exception.getHttpStatus(),exception.getErrorMessage(), exception.getErrorDesc(),LocalDateTime.now()),exception.getHttpStatus());
    }

    record ErrorResponse(HttpStatus code, String message , String desc, LocalDateTime timeStamp){}
}
