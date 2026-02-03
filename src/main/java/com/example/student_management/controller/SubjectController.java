package com.example.student_management.controller;

import com.example.student_management.dto.request.SubjectRequestDTO;
import com.example.student_management.dto.response.SubjectResponseDTO;
import com.example.student_management.service.impl.SubjectServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/v1/subject")
public class SubjectController {

    private final SubjectServiceImpl service;
    public SubjectController(SubjectServiceImpl service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@Valid @RequestBody SubjectRequestDTO dto){
        return new ResponseEntity<>(service.saveSubject(dto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<SubjectResponseDTO>> getAllSubject() {
        return ResponseEntity.ok(service.getAllSubject());
    }

    @GetMapping("/subjectId/{subjectId}")
    public ResponseEntity<SubjectResponseDTO> getSubjectById(@PathVariable Long subjectId){
        return ResponseEntity.ok(service.getSubjectById(subjectId));
    }

    @GetMapping("/subjectName/{subjectName}")
    public ResponseEntity<SubjectResponseDTO> getSubjectByName(@PathVariable String subjectName){
        return ResponseEntity.ok(service.getSubjectByName(subjectName));
    }

    @PutMapping("/subjectId/{subjectId}")
    public ResponseEntity<SubjectResponseDTO> updateSubjectById(
            @PathVariable @Min(1) Long subjectId,
            @Valid
            @RequestBody SubjectRequestDTO dto){
        return ResponseEntity.ok(service.updateSubjectById(subjectId,dto));
    }

    @DeleteMapping("/subjectId/{subjectId}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable Long subjectId){
        service.deleteSubjectById(subjectId);
        return ResponseEntity.noContent().build();
    }
}
