package com.job_room.schedule_service.model.reponse;

public class ScheduleCandidate {
    private int id;
    private int announcementId;
    private AnnouncementResponse announcement;
    private int employeeId;
    private EmployeeResponse employee;
    private String appliesDate;
    private String cvLink;
    private boolean status;
    public ScheduleCandidate(){}

    public ScheduleCandidate(int id, int announcementId, AnnouncementResponse announcement, int employeeId, EmployeeResponse employee, String appliesDate, String cvLink, boolean status) {
        this.id = id;
        this.announcementId = announcementId;
        this.announcement = announcement;
        this.employeeId = employeeId;
        this.employee = employee;
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

    public AnnouncementResponse getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(AnnouncementResponse announcement) {
        this.announcement = announcement;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
        this.employee = employee;
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
        return "ScheduleCandidate{" +
                "id=" + id +
                ", announcementId=" + announcementId +
                ", announcement=" + announcement +
                ", employeeId=" + employeeId +
                ", employee=" + employee +
                ", appliesDate='" + appliesDate + '\'' +
                ", cvLink='" + cvLink + '\'' +
                ", status=" + status +
                '}';
    }
}
