package com.example.student_management.dto.response;

public class SubjectResponseDTO {

    private Long subjectId;
    private String subjectName;

    public SubjectResponseDTO(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
