package com.example.student_management.dto.response;

public class UserResponseDTO {

    private Long userId;
    private String username;

    public UserResponseDTO(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId(){ return userId; }

    public String getUsername() { return username; }

}
