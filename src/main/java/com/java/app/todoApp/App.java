package com.java.app.todoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App 
{
    public static void main(String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
