package com.auth2.azuread.controller.rest;



import org.hibernate.boot.jaxb.mapping.marshall.TemporalTypeMarshalling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mail")
public class TestController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping
    public TestMoesl test(@RequestBody @Validated  TestMoesl testMoesl){
        return testMoesl;
    }


    @GetMapping("/{email}")
    public Map<String,Object> sendmail(@PathVariable(name = "email")String email){
        System.out.println(email);
        String messageRes = "success";
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("tarcharoenpronprasit@gmail.com");
            message.setTo(email);
            message.setSubject("subject");
            message.setText("Hello world");
            emailSender.send(message);

        }catch (Exception ex){
            ex.printStackTrace();
            messageRes =ex.getMessage();
        }


        return Map.of("status","success","message",messageRes);
    }
}
