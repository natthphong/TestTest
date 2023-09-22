package com.auth2.azuread.test;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testComponentTest")
@Slf4j
public class TestComponent {


    @Value("#{environment['app.spel'] == null ? T(com.auth2.azuread.test.TestComponent).greet('hello world') : environment['app.spel'] }")
    private String spEl;



    @PostConstruct
    public void eiei(){
        log.info("eiei {}" , spEl);
    }

    @PreDestroy
    public void clean(){
        log.info("clean");
    }


    public static String greet(String name) {
        return "Hello, " + name + "!";
    }




}
