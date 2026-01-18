package com.example.student_management.controller;


import com.example.student_management.dto.request.UserRequestDTO;
import com.example.student_management.dto.response.UserResponseDTO;
import com.example.student_management.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/users")
public class UserController {

    // Constructor
    private final UserServiceImpl service;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserServiceImpl service, PasswordEncoder passwordEncoder){
        this.service=service;
        this.passwordEncoder=passwordEncoder;
    }

    // Create User
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return new ResponseEntity<>(service.saveUser(dto), HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return  ResponseEntity.ok(service.getAllUsers());
    }

    // READ BY UserID
    @GetMapping("/id/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(service.getUserById(userId));
    }

    // READ BY UserName
    @GetMapping("/name/{username}")
    public ResponseEntity<UserResponseDTO> getUserByName(@PathVariable String username){
        return ResponseEntity.ok(service.getUserByUsername(username));
    }

    // Update By UserId
    @PutMapping("/id/{userId}")
    public ResponseEntity<UserResponseDTO> updateUserById(
            @PathVariable @Min(1) Long userId,
            @Valid
            @RequestBody UserRequestDTO dto){
        return ResponseEntity.ok(service.updateById(userId, dto));
    }

    // Delete By UserId
    @DeleteMapping("/id/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId){
        service.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
