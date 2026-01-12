package com.example.student_management.controller;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.PageResponseDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.service.impl.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Validated
@RestController
@RequestMapping("/v1/students")
public class StudentController {

    // Constructor Injection

    private final StudentServiceImpl service;
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    // Create Student
    @Operation(
            summary = "Create a new Student",
            description = "Create a student with name, email and course"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description="Student created successfully"),
            @ApiResponse(responseCode = "400", description="Validation error")
    })
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return new ResponseEntity<>(service.saveStudent(dto), HttpStatus.CREATED);
    }

    // READ ALL
    @Operation(
            summary = "Get all students",
            description = "Fetches all students"
    )
    @ApiResponses({
            @ApiResponse(responseCode ="200", description="Students retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not retrieved ")
    })
    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // Paged
    @Operation(
            summary = "Get Students with pagination and sorting",
            description = "Supports page, size, sort field and direction"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not retrieve")
    })
    @GetMapping("/paged")
    public ResponseEntity<PageResponseDTO<StudentResponseDTO>> getAllStudentsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return  ResponseEntity.ok(
                service.getAllStudentPage(page, size, sortBy, direction));
    }

    // READ BY ID
    @Operation(
            summary = "Get Student by ID",
            description = "Fetches a students using its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // READ BY EMAIL
    @Operation(
            summary = "Get Student by Email",
            description = "Fetches a students using its Email"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentResponseDTO> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getStudentByEmail(email));
    }


    // READ BY NAME
    @Operation(
            summary = "Get Student by Name",
            description = "Fetches a students using its Name"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getStudentByName(name));
    }

    // UPDATE BY ID
    @Operation(
            summary = "Update student by ID",
            description = "Updating student by ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/id/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentById(
            @PathVariable @Min(1) Long id,
            @Valid
            @RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }


    // DELETE BY ID
    @Operation(
            summary = "Delete student by ID",
            description = "Deleting student by ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student deleted successfully by using id"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE BY Email
    @Operation(
            summary = "Delete student by Email",
            description = "Deleting student by Email"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student deleted successfully using email"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/email/{email}")
    public  ResponseEntity<Void> deleteStudentByEmail(@PathVariable String email){
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
