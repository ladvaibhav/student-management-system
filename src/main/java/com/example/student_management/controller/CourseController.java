package com.example.student_management.controller;

import com.example.student_management.dto.request.CourseRequestDTO;
import com.example.student_management.dto.response.CourseResponseDTO;
import com.example.student_management.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private final CourseServiceImpl service;

    public CourseController(CourseServiceImpl service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CourseRequestDTO dto) {
        return new ResponseEntity<>(service.saveCourse(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/deptId/{deptId}")
    public ResponseEntity<List<CourseResponseDTO>> getCourseByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(service.getCourseByDepartment(deptId));
    }

    @GetMapping("/id/{courseId}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long courseId){
        return ResponseEntity.ok(service.getCourseById(courseId));
    }

    @GetMapping("/name/{courseName}")
    public ResponseEntity<CourseResponseDTO> getCourseByName(@PathVariable String courseName) {
        return ResponseEntity.ok(service.getCourseByName(courseName));
    }

    @PutMapping("/id/{courseId}")
    public ResponseEntity<CourseResponseDTO> updateCourseById(
            @PathVariable @Min(1) Long courseId,
            @Valid
            @RequestBody CourseRequestDTO dto){
        return ResponseEntity.ok(service.updateCourseById(courseId, dto));
    }

    @DeleteMapping("/id/{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId){
        service.deleteCourseById(courseId);
        return ResponseEntity.noContent()
                .build();    }

}

