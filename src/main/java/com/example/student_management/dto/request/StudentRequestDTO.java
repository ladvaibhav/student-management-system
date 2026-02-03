package com.example.student_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class StudentRequestDTO {

    @NotBlank(message = "Name is Required")
    private String name;

    @Email(message = "Enter valid Email ID")
    @NotBlank(message = "Email is Required")
    private String email;

    @NotNull(message = "Phone number is required")
    private String phone;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone){ this.phone=phone; }

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob){ this.dob=dob; }
}
