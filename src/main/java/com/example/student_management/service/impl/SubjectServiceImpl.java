package com.example.student_management.service.impl;

import com.example.student_management.dto.request.SubjectRequestDTO;
import com.example.student_management.dto.response.SubjectResponseDTO;
import com.example.student_management.entity.Subjects;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.SubjectMapper;
import com.example.student_management.repository.SubjectRepository;
import com.example.student_management.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    public SubjectServiceImpl(SubjectRepository repository) {
        this.repository = repository;
    }

    // Create
    @Override
    public SubjectResponseDTO saveSubject(SubjectRequestDTO dto) {
        Subjects subject = SubjectMapper.toEntity(dto);
        return SubjectMapper.toResponse(repository.save(subject));
    }

    @Override
    public List<SubjectResponseDTO> getAllSubject() {
        return repository.findAll()
                .stream()
                .map(SubjectMapper::toResponse)
                .toList();
    }

    @Override
    public SubjectResponseDTO getSubjectById(Long subjectId) {
        Subjects subject = findByIdOrThrow(subjectId);
        return SubjectMapper.toResponse(subject);
    }

    @Override
    public SubjectResponseDTO getSubjectByName(String subjectName) {
        Subjects subject = findByNameOrThrow(subjectName);
        return SubjectMapper.toResponse(subject);
    }

    @Override
    public SubjectResponseDTO updateSubjectById(Long subjectId, SubjectRequestDTO dto) {
        Subjects subject = findByIdOrThrow(subjectId);
        SubjectMapper.updateEntity(subject, dto);
        return SubjectMapper.toResponse(repository.save(subject));
    }

    @Override
    public void deleteSubjectById(Long subjectId) {
        repository.delete(findByIdOrThrow(subjectId));
    }

    // Helper
    private Subjects findByIdOrThrow(Long subjectId) {
        return repository.findById(subjectId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Subject not found by Id "+subjectId));
    }

    private Subjects findByNameOrThrow(String subjectName){
        return repository.findBySubjectName(subjectName)
                .orElseThrow(()->
                        new ResourceNotFoundException("Subject not found By name "+subjectName));
    }
}
