package com.job_room.employee_service.model.dto;

public class EmployeeDto {
    private int id;
    private String fullName;
    private String gender;
    private String address;
    private String email;
    private String password;
    private String date_of_birth;
    private String telephone;
    private String profile_picture;
    private boolean status;
    public EmployeeDto(){}

    public EmployeeDto(int id, String fullName, String gender, String address, String email, String password, String date_of_birth, String telephone, String profile_picture, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.telephone = telephone;
        this.profile_picture = profile_picture;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
