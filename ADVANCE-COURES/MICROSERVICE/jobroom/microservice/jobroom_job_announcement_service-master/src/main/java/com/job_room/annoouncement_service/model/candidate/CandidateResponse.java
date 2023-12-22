package com.job_room.annoouncement_service.model.candidate;

public class CandidateResponse {

    private int id;
    private int announcementId;
    private int employeeId;
    private String appliesDate;
    private String cvLink;
    private boolean status;
    public CandidateResponse(){}

    public CandidateResponse(int id, int announcementId, int employeeId, String appliesDate, String cvLink, String email, boolean status) {
        this.id = id;
        this.announcementId = announcementId;
        this.employeeId = employeeId;
        this.appliesDate = appliesDate;
        this.cvLink = cvLink;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAppliesDate() {
        return appliesDate;
    }

    public void setAppliesDate(String appliesDate) {
        this.appliesDate = appliesDate;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CandidateResponse{" +
                "id=" + id +
                ", announcementId=" + announcementId +
                ", employeeId=" + employeeId +
                ", appliesDate='" + appliesDate + '\'' +
                ", cvLink='" + cvLink + '\'' +
                ", status=" + status +
                '}';
    }
}
