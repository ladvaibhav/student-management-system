package com.example.student_management.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class StudentRequestDTO {

    @NotBlank(message = "Name is Required")
    private String name;

    @Email(message = "Enter valid Email ID")
    @NotBlank(message = "Email is Required")
    private String email;

    @NotNull(message = "Phone number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "phone number must be 10 digits"
    )
    private String phone;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of birth must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
