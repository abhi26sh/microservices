package com.example.students.Services;

import com.example.students.Models.Student;
import com.example.students.Responses.StudentDep;
import org.apache.catalina.LifecycleState;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;


public interface StudentService {


    Student createStudent(Student s);

    Student updateStudent(Student s, Integer sId);

    void deleteStudent(Integer sId);

    Student getStudentById(Integer sId);


     List<Student> getAllStudents();

    StudentDep getStudentDept(Integer studId);
}
