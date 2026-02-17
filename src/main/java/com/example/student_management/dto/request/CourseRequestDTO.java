package com.example.student_management.dto.request;

import com.example.student_management.entity.Departments;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CourseRequestDTO {

    @NotBlank
    private String courseName;

    @Min(value = 1, message = "Department id must be grater than 0")
    private Long deptId;

    public String getCourseName() {
        return courseName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}
