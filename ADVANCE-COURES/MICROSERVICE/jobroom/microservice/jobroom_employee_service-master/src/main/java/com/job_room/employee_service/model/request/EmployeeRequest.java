package com.job_room.employee_service.model.request;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
public class EmployeeRequest {
    @NotBlank(message = "Full name cannot be empty")
    private String full_name;
    @NotBlank(message = "Gender cannot be empty")
    private String gender;
    @NotBlank(message = "Address cannot be empty")
    private String address;
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @NotBlank(message = "Date Of Birth cannot be empty")
    private String date_of_birth;
    @NotBlank(message = "telephone")
    private String telephone;
    @NotBlank(message = "Profile picture cannot be empty")
    private String profile_picture;
    public EmployeeRequest(){}

    public EmployeeRequest(String full_name, String gender, String address, String email, String password, String date_of_birth, String telephone, String profile_picture) {
        this.full_name = full_name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.telephone = telephone;
        this.profile_picture = profile_picture;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
