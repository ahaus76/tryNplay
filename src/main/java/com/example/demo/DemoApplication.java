package com.example.demo;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableVaadin
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("Start:");
        SpringApplication.run(DemoApplication.class);
        System.out.println("Start:******************************************************");
    }
}
