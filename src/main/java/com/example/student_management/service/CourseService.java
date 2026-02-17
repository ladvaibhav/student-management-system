package com.example.student_management.service;

import com.example.student_management.dto.request.CourseRequestDTO;
import com.example.student_management.dto.response.CourseResponseDTO;

import java.util.List;


public interface CourseService {

    CourseResponseDTO saveCourse(CourseRequestDTO dto);

    List<CourseResponseDTO> getAllCourses();

    List<CourseResponseDTO> getCourseByDepartment(Long deptId);

    CourseResponseDTO getCourseById(Long courseId);

    CourseResponseDTO getCourseByName(String courseName);

    CourseResponseDTO updateCourseById(Long courseId, CourseRequestDTO dto);

    void deleteCourseById(Long courseId);

}
