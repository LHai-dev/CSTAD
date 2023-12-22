package com.job_room.annoouncement_service.model.candidate;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CandidateRequest {

    @NotNull(message = "Announcement Id cannot be empty")
    private int announcementId;

    @NotNull(message = "Employee Id cannot be empty")
    private int employeeId;

    @NotBlank(message = "CV Link Id cannot be empty")
    private String cvLink;


    public CandidateRequest(){}

    public CandidateRequest( int announcementId, int employeeId,  String cvLink) {
        this.announcementId = announcementId;
        this.employeeId = employeeId;
        this.cvLink = cvLink;
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

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    @Override
    public String toString() {
        return "CandidateRequest{" +
                "announcementId=" + announcementId +
                ", employeeId=" + employeeId +
                ", cvLink='" + cvLink + '\'' +
                '}';
    }
}
