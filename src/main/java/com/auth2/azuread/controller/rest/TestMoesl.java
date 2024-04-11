package com.auth2.azuread.controller.rest;



import com.tar.tarson.anotations.validation.CustomValidEmpty;

import com.tar.tarson.anotations.validation.CustomValidSize;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class TestMoesl {

    @Size(max = 20)
    @CustomValidEmpty( exception = TestBaseEx.class,httpStatus = HttpStatus.BAD_REQUEST , errorMessage ="test not null" , checkIsBlank = false,checkIsEmpty = false)
    private String test;

    @CustomValidEmpty(exception = TestBaseEx.class,httpStatus = HttpStatus.INTERNAL_SERVER_ERROR , errorMessage ="num not null")
    private String num;


}
