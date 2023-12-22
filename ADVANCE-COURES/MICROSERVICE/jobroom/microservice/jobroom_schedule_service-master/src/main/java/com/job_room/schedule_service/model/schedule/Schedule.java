package com.job_room.schedule_service.model.schedule;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "jr_schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uuid;
    private String position;
    private String remark;
    @Column(name = "meeting_date")
    private String meetingDate;
    @Column(name = "hr_id")
    private int hrId;
    @Column(name = "candidate_id")
    private int candidateId;
    private boolean status;
    public Schedule(){}

    public Schedule(String uuid, String position, String remark, String meetingDate, int hrId, int candidateId, boolean status) {
        this.uuid = uuid;
        this.position = position;
        this.remark = remark;
        this.meetingDate = meetingDate;
        this.hrId = hrId;
        this.candidateId = candidateId;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
