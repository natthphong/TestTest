package com.auth2.azuread.controller.rest;



import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TestController {


    @PostMapping
    public TestMoesl test(@RequestBody @Validated  TestMoesl testMoesl){
        return testMoesl;
    }

}
