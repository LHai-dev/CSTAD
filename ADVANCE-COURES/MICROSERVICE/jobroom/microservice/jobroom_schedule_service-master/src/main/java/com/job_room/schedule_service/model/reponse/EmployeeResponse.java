package com.job_room.schedule_service.model.reponse;

public class EmployeeResponse {
    private int id;
    private String fullName;
    private String gender;
    private String address;
    private String email;
    private String dateOfBirth;
    private String telephone;
    private String profilePicture;
    private boolean status;
    public EmployeeResponse(){}
    public EmployeeResponse(int id, String fullName, String gender, String address, String email, String dateOfBirth, String telephone, String profilePicture, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.profilePicture = profilePicture;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CandidateEmployee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", telephone='" + telephone + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", status=" + status +
                '}';
    }
}
