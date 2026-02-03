package com.example.student_management.dto.response;

public class DepartmentResponseDTO {

    private Long deptId;
    private String deptName;

    public DepartmentResponseDTO(Long deptId, String deptName){
        this.deptId=deptId;
        this.deptName=deptName;
    }

    public Long getDeptId(){
        return deptId;
    }

    public String getDeptName(){
        return deptName;
    }

}
