package com.auth2.azuread;

import com.tar.flyway.MigrationRunner;
import com.tar.flyway.model.Migration;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableCaching
//@EnableScheduling
@Slf4j
//@ComponentScan(basePackages = {"com.auth2","com.tar"})
public class AzureadApplication {




    public static void main(String[] args) {
//        System.exit(SpringApplication.exit(SpringApplication.run(AzureadApplication.class, args)));
        SpringApplication.run(AzureadApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("tarcharoenpronprasit@gmail.com");
        mailSender.setPassword("001122pass");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }




//    @Scheduled(fixedDelay = 5000)
//    public void scheduled(){
//        log.info("{}" ,System.currentTimeMillis());
//        try {
//            log.info("{} sleep" , Thread.currentThread().getName());
//            Thread.sleep(10000);
//            log.info("{} wake up " , Thread.currentThread().getName());
//        }catch (Exception ex){
//
//        }
//    }





}


