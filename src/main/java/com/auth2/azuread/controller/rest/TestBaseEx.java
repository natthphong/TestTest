package com.auth2.azuread.controller.rest;

import com.auth2.azuread.BaseException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class TestBaseEx extends BaseException {
    public TestBaseEx(HttpStatus httpStatus, String errorCode, String errorDesc, String errorMessage) {
        super(httpStatus, errorCode, errorDesc, errorMessage);
    }

    public TestBaseEx(HttpStatus httpStatus, String errorCode, String errorDesc, String errorMessage, String errorTitle) {
        super(httpStatus, errorCode, errorDesc, errorMessage, errorTitle);
    }

    public TestBaseEx(HttpStatus httpStatus, String errorCode) {
        super(httpStatus, errorCode);
    }

    public TestBaseEx(HttpStatus httpStatus, String errorCode, String suffixMsg) {
        super(httpStatus, errorCode, suffixMsg);
    }

    public TestBaseEx(HttpStatus httpStatus, String errorCode, Map<String, String> placeholder) {
        super(httpStatus, errorCode, placeholder);
    }
}
