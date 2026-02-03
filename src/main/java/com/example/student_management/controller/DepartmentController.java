package com.example.student_management.controller;


import com.example.student_management.dto.request.DepartmentRequestDTO;
import com.example.student_management.dto.response.DepartmentResponseDTO;
import com.example.student_management.service.impl.DepartmentServiceImpl;
import com.example.student_management.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    // Constructor Injection
    private final DepartmentServiceImpl service;
    public DepartmentController(DepartmentServiceImpl service){
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO dto){
        return new ResponseEntity<>(service.saveDepartment(dto), HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
        return ResponseEntity.ok(service.getAllDepartments());
    }

    @GetMapping("/deptId/{deptId}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long deptId){
        return ResponseEntity.ok(service.getDepartmentById(deptId));
    }

    @GetMapping("/deptName/{deptName}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentByName(@PathVariable String deptName){
        return ResponseEntity.ok(service.getDepartmentByName(deptName));
    }

    @PutMapping("/deptId/{deptId}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartmentById(
            @PathVariable @Min(1) Long deptId,
            @Valid
            @RequestBody DepartmentRequestDTO dto){
        return ResponseEntity.ok(service.updateById(deptId, dto));
    }

    @DeleteMapping("/deptId/{deptId}")
    public ResponseEntity<Void> deleteDepatmentById(@PathVariable Long deptId){
        service.deleteById(deptId);
        return ResponseEntity.noContent().build();
    }
}
