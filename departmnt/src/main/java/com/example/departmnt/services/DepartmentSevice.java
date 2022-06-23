package com.example.departmnt.services;


import com.example.departmnt.Exceptions.ResourceNotFoundException;
import com.example.departmnt.models.Department;
import com.example.departmnt.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentSevice {

    @Autowired
    DepartmentRepo departmentRepo;

    public Department createDepartment(Department d)
    {
       return this.departmentRepo.save(d);
    }

    public Department getDepartment(Integer depId)
    {
        Department d= this.departmentRepo.findById(depId).orElseThrow(()-> new ResourceNotFoundException("Student","id",depId));

        return d;
    }
}
