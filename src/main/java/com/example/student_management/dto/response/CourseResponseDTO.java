package com.example.student_management.dto.response;

public class CourseResponseDTO {

    private Long courseId;
    private String courseName;
    private Long deptId;

    public CourseResponseDTO(Long courseId, String courseName, Long deptId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.deptId = deptId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Long getDeptId() {
        return deptId;
    }
}
