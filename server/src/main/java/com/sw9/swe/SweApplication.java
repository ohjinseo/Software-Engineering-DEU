package com.sw9.swe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SweApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweApplication.class, args);
    }

}
