package com.example.students.Services.impl;

import com.example.students.Models.Department;
import com.example.students.Models.Student;
import com.example.students.Repository.StudentRepo;
import com.example.students.Responses.StudentDep;
import com.example.students.Services.StudentService;
import com.example.students.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class StudentImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    StudentDeptService studentDeptService;

    @Override
    public Student createStudent(Student s) {

        Student student= this.studentRepo.save(s);
        return student;
    }

    @Override
    public Student updateStudent(Student stu, Integer sId) {
        Student s= this.studentRepo.findById(sId).orElseThrow(()-> new ResourceNotFoundException("Student","id",sId));
        s.setName(stu.getName());
        s.setDeptId(stu.getDeptId());
        return this.studentRepo.save(s);
    }

    @Override
    public void deleteStudent(Integer sId) {

        Student s= this.studentRepo.findById(sId).orElseThrow(()-> new ResourceNotFoundException("Student","id",sId));
        this.studentRepo.delete(s);


    }

    @Override
    public Student getStudentById(Integer sId) {
        Student s= this.studentRepo.findById(sId).orElseThrow(()-> new ResourceNotFoundException("Student","id",sId));

        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudent= this.studentRepo.findAll();
        return allStudent;
    }

    @Override
    public StudentDep getStudentDept(Integer studId) {
        Student s= this.studentRepo.findById(studId).orElseThrow(()-> new ResourceNotFoundException("Student","id",studId));
        Department department= studentDeptService.getDepartment(s.getDeptId());
        return new StudentDep(s.getId(),s.getName(),s.getDeptId(),department.getDeptName());
    }



}
