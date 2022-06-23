package com.example.departmnt.controller;


import com.example.departmnt.models.Department;
import com.example.departmnt.services.DepartmentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentSevice departmentSevice;

    @PostMapping("/add")
    public ResponseEntity<Department>  addDepartment(@RequestBody Department d)
    {
        return new ResponseEntity<>(this.departmentSevice.createDepartment(d), HttpStatus.CREATED);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Department>  getDepartment(@PathVariable Integer deptId)
    {
        return new ResponseEntity<>(this.departmentSevice.getDepartment(deptId), HttpStatus.OK);
    }

}
