package com.example.student_management.repository;

import com.example.student_management.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {

    Optional<Departments> findByDeptName(String deptName);
}
