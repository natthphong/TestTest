package com.auth2.azuread.test;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener  implements ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Application context initialized.");

    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStarted(ApplicationStartedEvent event) {
        // Perform startup actions
        System.out.println("Application started.");
    }
    @EventListener
    public void onContextClosedEvent(ContextClosedEvent event) {
        // Shutdown logic
        System.out.println("Application context closed.");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application context initialized.CommandLineRunner ");

    }
}
