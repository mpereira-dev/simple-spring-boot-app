package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Scan application for spring components and wires them up using autoconfiguration
 */
@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        // Fires up spring boot when main is run
        SpringApplication.run(App.class, args);
    }
}
