package com.bunker.padel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaddleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaddleApplication.class, args);
    }

}
