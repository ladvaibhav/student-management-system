package com.example.student_management.service.impl;

import com.example.student_management.dto.request.DepartmentRequestDTO;
import com.example.student_management.dto.response.DepartmentResponseDTO;
import com.example.student_management.entity.Departments;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.DepartmentMapper;
import com.example.student_management.repository.DepartmentRepository;
import com.example.student_management.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    // Constructor Injection
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    // Create
    @Override
    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO dto) {
        Departments department = DepartmentMapper.toEntity(dto);
        return DepartmentMapper.toResponse(repository.save(department));
    }

    // READ
    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(DepartmentMapper::toResponse)
                .toList();
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long deptId) {
        Departments department = findByIdOrThrow(deptId);
        return DepartmentMapper.toResponse(department);
    }

    @Override
    public DepartmentResponseDTO getDepartmentByName(String deptName) {
        Departments department = findByNameOrThrow(deptName);
        return DepartmentMapper.toResponse(department);
    }

    // Update
    @Override
    public DepartmentResponseDTO updateById(Long deptId, DepartmentRequestDTO dto) {
        Departments department = findByIdOrThrow(deptId);
        DepartmentMapper.updateEntity(department, dto);
        return DepartmentMapper.toResponse(repository.save(department));
    }

    // Delete
    @Override
    public void deleteById(Long deptId) {
        repository.delete(findByIdOrThrow(deptId));
    }

    // Helper
    private Departments findByIdOrThrow(Long deptId) {
        return repository.findById(deptId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Department not found with id: "+deptId));
    }

    private Departments findByNameOrThrow(String deptName) {
        return repository.findByDeptName(deptName)
                .orElseThrow(()->
                        new ResourceNotFoundException("Department not found with department Name: "+deptName));
    }

}
