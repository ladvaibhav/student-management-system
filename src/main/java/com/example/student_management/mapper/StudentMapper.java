package com.example.student_management.mapper;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.entity.Students;

public class StudentMapper {

    private StudentMapper(){
    }

    // Create
    public static Students toEntity(StudentRequestDTO dto) {
        if(dto==null){
            return null;
        }
        Students student = new Students();
        mapRequestToEntity(student,dto);
        return student;
    }

    // Update
    public static void updateEntity(Students student, StudentRequestDTO dto){
        if(student==null || dto==null){
            return;
        }
        mapRequestToEntity(student, dto);
    }

    // Read
    public static StudentResponseDTO toResponse(Students student) {
        if(student==null){
            return null;
        }
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getDob()
        );
    }

    // Helper
    private static void mapRequestToEntity(Students student,StudentRequestDTO dto){
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setDob(dto.getDob());
    }

}
