package com.example.student_management.repository;

import com.example.student_management.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Courses, Long> {

    Optional<Courses> findByCourseNameIgnoreCase(String courseName);

    boolean existsByCourseName(String courseName);

    List<Courses> findByDepartmentDeptId(Long deptId);

}
