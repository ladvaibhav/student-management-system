package com.example.student_management.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SubjectRequestDTO {

    @NotBlank(message = "Subject is Required")
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
