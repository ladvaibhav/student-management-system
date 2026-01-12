package com.example.student_management.mapper;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.entity.Students;

public class StudentMapper {

    // Create
    public static Students toEntity(StudentRequestDTO dto) {
        Students student = new Students();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        return student;
    }

    // Update
    public static void updateEntity(Students student, StudentRequestDTO dto){
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
    }

    // READ
    public static StudentResponseDTO toResponse(Students student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
}
