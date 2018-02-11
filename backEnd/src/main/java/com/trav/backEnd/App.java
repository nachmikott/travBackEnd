package com.trav.backEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan({"com.trav.api.controllers", "com.trav.models", "com.trav.services", "com.trav.services.impl"}) //Defines where to scan components/services/controllers 
public class App 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(App.class, args);
    }
}
