package com.example.StudentManagement.repo;

import com.example.StudentManagement.model.Course;
import com.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Long> {
}
