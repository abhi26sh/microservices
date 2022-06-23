package com.example.students;

import com.example.students.Config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class StudentsApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentsApplication.class, args);

    }



}
