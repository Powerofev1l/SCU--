package com.example.booksystem.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/*
    u_id INT PRIMARY KEY AUTO_INCREMENT,
    u_name VARCHAR(50) NOT NULL,
    u_password VARCHAR(20) NOT NULL,
    u_gender ENUM('男','女') NOT NULL,
    u_department VARCHAR(20) NOT NULL,
    u_grade INT NOT NULL
 */

public class User {
    private Integer uId;
    private String uName;
    private String uPassword;
    private String uGender;
    private String uDepartment;
    private Integer uGrade;

    public User() {
    }

    public User(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public User(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade) {
        this.uId = uId;
        this.uName = uName;
        this.uGender = uGender;
        this.uDepartment = uDepartment;
        this.uGrade = uGrade;
    }

    public User(String uName, String uPassword, String uGender, String uDepartment, Integer uGrade) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uGender = uGender;
        this.uDepartment = uDepartment;
        this.uGrade = uGrade;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuDepartment() {
        return uDepartment;
    }

    public void setuDepartment(String uDepartment) {
        this.uDepartment = uDepartment;
    }

    public Integer getuGrade() {
        return uGrade;
    }

    public void setuGrade(Integer uGrade) {
        this.uGrade = uGrade;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uGender='" + uGender + '\'' +
                ", uDepartment='" + uDepartment + '\'' +
                ", uGrade=" + uGrade +
                '}';
    }
}
