package com.example.gateway;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

public class FallBackController {

/*
    @RequestMapping("/studentFallBack")
    public Mono<String> studentServiceFallBack()
    {
        return Mono.just("Student service is  down. please try again later ");
    }

    @RequestMapping("/departmentFallBack")
    public Mono<String> departmentServiceFallBack()
    {
        return Mono.just("department service is  down. please try again later ");
    }
              filters:
            - name: CircuitBreaker
              args:
                name: department-Service
                fallbackuri: forward:/departmentFallBack
*/

}
