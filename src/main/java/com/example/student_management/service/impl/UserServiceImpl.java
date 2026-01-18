package com.example.student_management.service.impl;

import com.example.student_management.dto.request.UserRequestDTO;
import com.example.student_management.dto.response.UserResponseDTO;
import com.example.student_management.entity.Users;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.UserMapper;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // Constructor Injection
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository){ this.repository=repository;}

    // Create
    @Override
    public UserResponseDTO saveUser(UserRequestDTO dto){
        Users user = UserMapper.toEntity(dto);
        return UserMapper.toResponse(repository.save(user));
    }

    // READ
    @Override
    public List<UserResponseDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long userId){
        Users user = findByUserIdorThrow(userId);
        return UserMapper.toResponse(user);
    }

    @Override
    public UserResponseDTO getUserByUsername(String username){
        Users user = findUserByUsernameorThrow(username);
        return UserMapper.toResponse(user);
    }

    // UPDATE
    @Override
    public UserResponseDTO updateById(Long userId, UserRequestDTO dto) {
        Users user = findByUserIdorThrow(userId);
        UserMapper.updateEntity(user, dto);
        return UserMapper.toResponse(repository.save(user));
    }

    // DELETE
    @Override
    public void deleteUserById(Long userId){
        repository.delete(findByUserIdorThrow(userId));
    }



    // Helper
    private Users findByUserIdorThrow(Long userId) {
        return repository.findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException("User not found with id" + userId));

    }

    private  Users findUserByUsernameorThrow(String username){
        return repository.findByUsername(username)
                .orElseThrow(()->
                       new ResourceNotFoundException("User not found with username" + username));
    }
}
