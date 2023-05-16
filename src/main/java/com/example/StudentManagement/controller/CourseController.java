package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Course;
import com.example.StudentManagement.service.CourseService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping()
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping()
    public List<Course> getAllCourse(@Nullable @RequestParam Long courseId){
        return courseService.getAllCourse(courseId);
    }

    @DeleteMapping("/{courseId}")
    public String deleteCourseById(@PathVariable Long courseId){
        return courseService.deleteCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public String updateCourse(@PathVariable Long courseId , @RequestBody Course course){
        return courseService.updateCourse(courseId , course);
    }
}
