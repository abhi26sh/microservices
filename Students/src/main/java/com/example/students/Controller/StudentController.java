package com.example.students.Controller;


import com.example.students.Models.Department;
import com.example.students.Models.Student;
import com.example.students.Responses.ApiResponse;
import com.example.students.Responses.StudentDep;
import com.example.students.Services.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(this.studentService.createStudent(student), HttpStatus.CREATED);
    }


    @PutMapping("/update/{sId}")
    public  ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer sId){
        return new ResponseEntity<>(this.studentService.updateStudent(student,sId),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer studentId){
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<>(new ApiResponse("Student deleted Successfully",true),HttpStatus.ACCEPTED);
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId)
    {
        return new ResponseEntity<>(this.studentService.getStudentById(studentId),HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Student>> getALlStudents()
    {
        return new ResponseEntity<>(this.studentService.getAllStudents(),HttpStatus.OK);
    }


    @GetMapping("/dept/{studId}")

    public ResponseEntity<StudentDep> getStudentDepartment( @PathVariable Integer studId )
    {
        StudentDep s=this.studentService.getStudentDept(studId);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }


}

