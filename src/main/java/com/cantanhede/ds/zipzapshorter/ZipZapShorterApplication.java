package com.cantanhede.ds.zipzapshorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
class ZipzapshorterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipzapshorterApplication.class, args);
    }
}