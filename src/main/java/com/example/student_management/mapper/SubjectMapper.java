package com.example.student_management.mapper;

import com.example.student_management.dto.request.SubjectRequestDTO;
import com.example.student_management.dto.response.SubjectResponseDTO;
import com.example.student_management.entity.Subjects;

public class SubjectMapper {

    private SubjectMapper(){

    }

    // Create
    public static Subjects toEntity(SubjectRequestDTO dto){
        if(dto==null){
            return null;
        }

        Subjects subject = new Subjects();
        mapRequestToEntity(subject, dto);
        return subject;
    }

    // Update
    public static void updateEntity(Subjects subject, SubjectRequestDTO dto){
        if(subject==null || dto==null){
            return;
        }
        mapRequestToEntity(subject, dto);
    }

    // READ
    public static SubjectResponseDTO toResponse(Subjects subject){
        if(subject==null){
            return null;
        }
        return new SubjectResponseDTO(
                subject.getSubjectId(),
                subject.getSubjectName()
        );
    }


    // Helper
    private static void mapRequestToEntity(Subjects subject, SubjectRequestDTO dto){
        subject.setSubjectName(dto.getSubjectName());
    }
}
