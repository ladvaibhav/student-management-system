package com.example.student_management.service.impl;

import com.example.student_management.dto.request.CourseRequestDTO;
import com.example.student_management.dto.response.CourseResponseDTO;
import com.example.student_management.entity.Courses;
import com.example.student_management.entity.Departments;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.CourseMapper;
import com.example.student_management.repository.CourseRepository;
import com.example.student_management.repository.DepartmentRepository;
import com.example.student_management.service.CourseService;
import jakarta.validation.constraints.Min;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final DepartmentRepository departmentRepository;

    public CourseServiceImpl(CourseRepository repository, DepartmentRepository departmentRepository){
        this.repository=repository;
        this.departmentRepository=departmentRepository;
    }

    // Create
    @Override
    public CourseResponseDTO saveCourse(CourseRequestDTO dto) {

        if (repository.existsByCourseName(dto.getCourseName())) {
            throw new IllegalStateException(
                    "Course already exists with name: " + dto.getCourseName()
            );
        }

        Departments dept = departmentRepository.findById(dto.getDeptId())
                .orElseThrow(()->
                        new ResourceNotFoundException(
                           "Department not found with id: "+dto.getDeptId()
                        ));
        Courses course = new Courses();
        course.setCourseName(dto.getCourseName());
        course.setDepartment(dept);

        return CourseMapper.toResponse(repository.save(course));
    }

    // Read
    @Transactional(readOnly = true)
    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return repository.findAll()
                .stream()
                .map(CourseMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourseResponseDTO> getCourseByDepartment(Long deptId) {
        return repository.findByDepartmentDeptId(deptId)
                .stream()
                .map(CourseMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CourseResponseDTO getCourseById(Long courseId) {
        Courses course = findByIdorThrow(courseId);
        return CourseMapper.toResponse(course);
    }

    @Transactional(readOnly = true)
    @Override
    public CourseResponseDTO getCourseByName(String courseName) {
        Courses course = findByNameorThrow(courseName);
        return CourseMapper.toResponse(course);
    }


    // Update
    @Override
    public CourseResponseDTO updateCourseById(@Min(1) Long courseId, CourseRequestDTO dto) {
        Courses course = findByIdorThrow(courseId);

        Departments dept = departmentRepository.findById(dto.getDeptId())
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Department not found with id: "+dto.getDeptId()
                        ));

        course.setCourseName(dto.getCourseName());
        course.setDepartment(dept);

        return CourseMapper.toResponse(repository.save(course));
    }

    @Override
    public void deleteCourseById(Long courseId) {
        repository.delete(findByIdorThrow(courseId));
    }

    // Helper
    private Courses findByIdorThrow(Long courseId) {
        return repository.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found with id: "+courseId));
    }

    private Courses findByNameorThrow(String courseName) {
        return repository.findByCourseNameIgnoreCase(courseName)
                .orElseThrow(()->
                        new ResourceNotFoundException("Course not found by name: "+courseName));
    }
}
