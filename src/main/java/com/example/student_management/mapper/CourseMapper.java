package com.example.student_management.mapper;

import com.example.student_management.dto.request.CourseRequestDTO;
import com.example.student_management.dto.response.CourseResponseDTO;
import com.example.student_management.entity.Courses;

public class CourseMapper {

    private CourseMapper(){

    }

    // Create
    public static Courses toEntity(CourseRequestDTO dto){
        if(dto==null){
            return null;
        }

        Courses course = new Courses();
        mapRequestToEntity(course, dto);
        return course;
    }

    // Update
    public static void updateEntity(Courses course, CourseRequestDTO dto){
        if (course==null || dto==null){
            return;
        }
        mapRequestToEntity(course, dto);
    }

    // Read
    public static CourseResponseDTO toResponse(Courses course){
        if (course==null){
            return null;
        }

        Long deptId = null;
        if (course.getDepartment() != null ){
            deptId = course.getDepartment().getDeptId();
        }

        return new CourseResponseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getDepartment().getDeptId()
        );
    }

    public static void mapRequestToEntity(Courses course, CourseRequestDTO dto){
        course.setCourseName(dto.getCourseName());
    }
}
