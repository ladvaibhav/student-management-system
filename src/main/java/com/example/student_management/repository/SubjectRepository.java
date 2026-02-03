package com.example.student_management.repository;

import com.example.student_management.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subjects, Long>{

    Optional<Subjects> findBySubjectName(String subjectName);
}
