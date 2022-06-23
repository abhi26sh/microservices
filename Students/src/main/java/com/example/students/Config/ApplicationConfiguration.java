package com.example.students.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

   @Bean
   @LoadBalanced
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate;

    }


}
