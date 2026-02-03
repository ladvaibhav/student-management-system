package com.example.student_management.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Long id;

    @Column(nullable = false, length=100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(name="Date-of-Birth",nullable = false)
    private LocalDate dob;

    // No argument Constructor required by JPA
    public Students() {
    }

    public Students(String name, String email, String phone, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    //Getters and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
