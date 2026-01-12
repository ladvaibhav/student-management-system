package com.example.student_management.repository;

import com.example.student_management.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Long> {

    // Find by id already implemented in JpaRepository
    List<Students> findByNameIgnoreCase(String name);
    Optional<Students> findByEmail(String email);

    // Delete by email
    // Delete by id is already implemented in JpaRepository
    void deleteByEmail(String email);

}
