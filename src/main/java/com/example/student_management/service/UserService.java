package com.example.student_management.service;

import com.example.student_management.dto.request.UserRequestDTO;
import com.example.student_management.dto.response.UserResponseDTO;
import com.example.student_management.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    UserResponseDTO saveUser(UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long userId) throws ResourceNotFoundException;

    UserResponseDTO getUserByUsername(String username);

    UserResponseDTO updateById(Long userId, UserRequestDTO updatedUser);

    void deleteUserById(Long id);

}
