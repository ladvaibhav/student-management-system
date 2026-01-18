package com.example.student_management.service;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.PageResponseDTO;
import com.example.student_management.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    StudentResponseDTO saveStudent(StudentRequestDTO student);

    List<StudentResponseDTO> getAllStudents();

    PageResponseDTO<StudentResponseDTO> getAllStudentPage(int page, int size, String sortBy, String direction);

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO getStudentByEmail(String email);

    List<StudentResponseDTO> getStudentByName(String name);

    StudentResponseDTO updateById(Long id, StudentRequestDTO updatedStudent);

    void deleteById(Long id);

    void deleteByEmail(String email);

}
