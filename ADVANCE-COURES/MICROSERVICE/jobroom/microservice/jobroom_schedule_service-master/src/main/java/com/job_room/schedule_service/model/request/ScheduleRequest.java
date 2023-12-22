package com.job_room.schedule_service.model.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ScheduleRequest {
    @NotBlank(message = "position cannot be empty")
    private String position;
    @NotBlank(message = "remark cannot be empty")
    private String remark;
    @NotBlank(message = "meetingDate cannot be empty")
    private String meetingDate;
    private int hrId;
    private int candidateId;
    public ScheduleRequest (){}

    public ScheduleRequest(String position, String remark, String meetingDate, int hrId, int candidateId) {
        this.position = position;
        this.remark = remark;
        this.meetingDate = meetingDate;
        this.hrId = hrId;
        this.candidateId = candidateId;
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
}
