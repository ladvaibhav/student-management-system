package com.example.student_management.service;

import com.example.student_management.dto.request.SubjectRequestDTO;
import com.example.student_management.dto.response.SubjectResponseDTO;

import java.util.List;

public interface SubjectService {

    SubjectResponseDTO saveSubject(SubjectRequestDTO dto);

    List<SubjectResponseDTO> getAllSubject();

    SubjectResponseDTO getSubjectById(Long subjectId);

    SubjectResponseDTO getSubjectByName(String subjectName);

    SubjectResponseDTO updateSubjectById(Long subjectId, SubjectRequestDTO dto);

    void deleteSubjectById(Long subjectId);
}
