package com.example.student_management.mapper;

import com.example.student_management.dto.request.DepartmentRequestDTO;
import com.example.student_management.dto.response.DepartmentResponseDTO;
import com.example.student_management.entity.Departments;

public class DepartmentMapper {

    private DepartmentMapper(){
    }

    // Create
    public static Departments toEntity(DepartmentRequestDTO dto){
        if(dto==null){
            return null;
        }
        Departments department = new Departments();
        mapRequestToEntity(department,dto);
        return department;
    }

    // Update
    public static void updateEntity(Departments department, DepartmentRequestDTO dto){
        if(department==null || dto==null){
            return;
        }
        mapRequestToEntity(department, dto);
    }

    // READ
    public static DepartmentResponseDTO toResponse(Departments department){
        if(department==null){
            return null;
        }
        return new DepartmentResponseDTO(
                department.getDeptId(),
                department.getDeptName()
        );
    }

    // Helper
    private static void mapRequestToEntity(Departments department, DepartmentRequestDTO dto){
        department.setDeptName(dto.getDeptName());
    }

}
