package com.example.student_management.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

    @NotBlank(message = "Department is Required")
    private String deptName;

    public String getDeptName(){
        return deptName;
    }

    public void setDeptName(String deptName){
        this.deptName=deptName;
    }
}
