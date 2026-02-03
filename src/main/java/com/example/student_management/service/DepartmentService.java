package com.example.student_management.service;

import com.example.student_management.dto.request.DepartmentRequestDTO;
import com.example.student_management.dto.response.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDTO saveDepartment(DepartmentRequestDTO dto);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long deptId);

    DepartmentResponseDTO getDepartmentByName(String deptName);

    DepartmentResponseDTO updateById(Long deptId, DepartmentRequestDTO dto);

    void deleteById(Long deptId);
}
