package com.job_room.annoouncement_service.model.candidate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class CandidateDto {
    private int id;
    private int announcementId;
    private int employeeId;
    private String appliesDate;
    private String cvLink;
    private String email;
    private boolean status;
    public CandidateDto(){}

    public CandidateDto(int id, int announcementId, int employeeId, String appliesDate, String cvLink, String email, boolean status) {
        this.id = id;
        this.announcementId = announcementId;
        this.employeeId = employeeId;
        this.appliesDate = appliesDate;
        this.cvLink = cvLink;
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "CandidateDto{" +
                "id=" + id +
                ", announcementId=" + announcementId +
                ", employeeId=" + employeeId +
                ", appliesDate='" + appliesDate + '\'' +
                ", cvLink='" + cvLink + '\'' +
                ", status=" + status +
                '}';
    }
}
