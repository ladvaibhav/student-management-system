

package com.example.student_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Departments{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private Long deptId;

    @Column(name = "dept_name", nullable = false,unique = true, length = 50)
    private String deptName;

    public Departments(){
    }

    public Departments(String deptName){
        this.deptName=deptName;
    }

    public Long getDeptId(){
        return deptId;
    }

    public String getDeptName(){
        return deptName;
    }

    public void setDeptName(String deptName){
        this.deptName=deptName;
    }

}
