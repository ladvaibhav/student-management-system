package com.example.student_management.dto.response;

import java.time.LocalDate;

public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate dob;


    public StudentResponseDTO(Long id, String name, String email, String phone, LocalDate dob ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDob() {
        return dob;
    }

}
