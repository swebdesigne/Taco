package ru.taco.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoApplication.class, args);
        System.out.println("http://localhost:8080");
    }

}
