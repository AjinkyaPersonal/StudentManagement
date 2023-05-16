package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping()
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudent(@Nullable @RequestParam Long studentId){
        return studentService.getAllStudent(studentId);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId){
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable Long studentId , @RequestBody Student student){
        return studentService.updateStudent(studentId , student);
    }
}
