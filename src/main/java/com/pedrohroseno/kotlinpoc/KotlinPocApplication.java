package com.pedrohroseno.kotlinpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableFeignClients
@SpringBootApplication
@ImportAutoConfiguration(value = FeignAutoConfiguration.class)
public class KotlinPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(KotlinPocApplication.class, args);
    }

}
