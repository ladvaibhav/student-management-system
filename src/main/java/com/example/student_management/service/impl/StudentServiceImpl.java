package com.example.student_management.service.impl;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.PageResponseDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.entity.Students;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    // Constructor Injection
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

   // Create
    @Override
    public StudentResponseDTO saveStudent(StudentRequestDTO dto){
        Students student = StudentMapper.toEntity(dto);
        return StudentMapper.toResponse(repository.save(student));
    }

    // READ
    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    @Override
    public PageResponseDTO<StudentResponseDTO> getAllStudentPage(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        PageRequest pageable = PageRequest.of(page, size, sort);
        Page<Students> studentPage = repository.findAll(pageable);

        List<StudentResponseDTO> content = studentPage.getContent()
                .stream()
                .map(StudentMapper::toResponse)
                .toList();

        return  new PageResponseDTO<>(
                content,
                studentPage.getNumber(),
                studentPage.getSize(),
                studentPage.getTotalElements(),
                studentPage.getTotalPages(),
                studentPage.isLast()
        );
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Students student = findByIdOrThrow(id);
        return StudentMapper.toResponse(student);
    }

    @Override
    public StudentResponseDTO getStudentByEmail(String email) {
       Students student = repository.findByEmail(email)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student not found or it does not exist with email: "+email));
               return StudentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponseDTO> getStudentByName(String name) {
        return repository.findByNameIgnoreCase(name)
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    // UPDATE
    @Override
    public StudentResponseDTO updateById(Long id, StudentRequestDTO dto){
        Students student = findByIdOrThrow(id);
        StudentMapper.updateEntity(student, dto);
        return StudentMapper.toResponse(repository.save(student));
    }

    // DELETE
    @Override
    public void deleteById(Long id){
        repository.delete(findByIdOrThrow(id));
    }

    @Override
    public void deleteByEmail(String email){
        Students student = repository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with email:"+email));
        repository.delete(student);
    }

    // Helper
    private Students findByIdOrThrow(Long id){
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: "+id));
    }

}
