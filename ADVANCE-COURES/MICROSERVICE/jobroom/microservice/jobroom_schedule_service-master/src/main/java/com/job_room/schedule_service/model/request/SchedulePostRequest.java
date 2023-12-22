package com.job_room.schedule_service.model.request;

import com.job_room.schedule_service.model.request.CandidateIdRequest;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

public class SchedulePostRequest {
    @NotBlank(message = "position cannot be empty")
    private String position;
    @NotBlank(message = "remark cannot be empty")
    private String remark;
    @NotBlank(message = "meeting date cannot be empty")
    private String meetingDate;

    private int hrId;
    private CandidateIdRequest[] candidateIdRequest;
    private String emailContent;

    public SchedulePostRequest (){}

    public SchedulePostRequest(String position,String remark,String meetingDate, int hrId, CandidateIdRequest[] candidateIdRequest, String emailContent) {
        this.position = position;
        this.remark = remark;
        this.meetingDate = meetingDate;
        this.hrId = hrId;
        this.candidateIdRequest = candidateIdRequest;
        this.emailContent = emailContent;
    }

    public CandidateIdRequest[] getCandidateIdRequest() {
        return candidateIdRequest;
    }

    public void setCandidateIdRequest(CandidateIdRequest[] candidateIdRequest) {
        this.candidateIdRequest = candidateIdRequest;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
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

    @Override
    public String toString() {
        return "SchedulePostRequest{" +
                "position='" + position + '\'' +
                ", remark='" + remark + '\'' +
                ", meetingDate='" + meetingDate + '\'' +
                ", hrId=" + hrId +
                ", candidateIdRequest=" + Arrays.toString(candidateIdRequest) +
                ", emailContent='" + emailContent + '\'' +
                '}';
    }
}