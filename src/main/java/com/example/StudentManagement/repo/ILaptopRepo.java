package com.example.StudentManagement.repo;

import com.example.StudentManagement.model.Laptop;
import com.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepo extends JpaRepository<Laptop, Long> {
}