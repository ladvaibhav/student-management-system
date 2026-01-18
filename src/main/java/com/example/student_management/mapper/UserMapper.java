package com.example.student_management.mapper;


import com.example.student_management.dto.request.UserRequestDTO;
import com.example.student_management.dto.response.UserResponseDTO;
import com.example.student_management.entity.Users;

public class UserMapper {

    // Create
    public static Users toEntity(UserRequestDTO dto) {
        Users user = new Users();
        user.setUsername(dto.getUsername().toLowerCase());
        user.setPassword(dto.getPassword());
        return user;
    }

    // Update
    public static void updateEntity(Users user, UserRequestDTO dto){
        user.setUsername(dto.getUsername().toLowerCase());
        user.setPassword(dto.getPassword());
    }

    // READ
    public static UserResponseDTO toResponse(Users user){
        return new UserResponseDTO(
                user.getUserId(),
                user.getUsername()
        );
    }
}
