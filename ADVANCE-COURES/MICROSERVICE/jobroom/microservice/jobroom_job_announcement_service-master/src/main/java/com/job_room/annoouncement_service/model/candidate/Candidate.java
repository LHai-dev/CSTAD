package com.job_room.annoouncement_service.model.candidate;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "jr_candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "announcement_id")
    private int announcementId;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "applies_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appliesDate;
    @Column(name = "cv_link")
    private String cvLink;
    private boolean status;

    public Candidate(){}


    public Candidate(int id, int announcementId, int employeeId, Date appliesDate, String cvLink, boolean status) {
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

    public Date getAppliesDate() {
        return appliesDate;
    }

    public void setAppliesDate(Date appliesDate) {
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
        return "Candidate{" +
                "id=" + id +
                ", announcementId=" + announcementId +
                ", employeeId=" + employeeId +
                ", appliesDate='" + appliesDate + '\'' +
                ", cvLink='" + cvLink + '\'' +
                ", status=" + status +
                '}';
    }
}
