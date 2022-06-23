package com.example.students.Services.impl;

import com.example.students.Models.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "DEPARTMENT-SERVICE/api/department")
public interface StudentDeptService {
    @RequestMapping(value = "/{deptId}",method = RequestMethod.GET)
    public Department getDepartment(@PathVariable Integer deptId);

}



