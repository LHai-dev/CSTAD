package com.job_room.schedule_service.model.reponse;

public class SelectScheduleResponse {
    private int id;
    private String uuid;
    private String position;
    private String remark;
    private String meetingDate;
    private int hrId;
    private int candidateId;
    private ScheduleCandidate candidate;
    private boolean status;
    public SelectScheduleResponse(){}

    public SelectScheduleResponse(int id, String uuid, String position, String remark, String meetingDate, int hrId, int candidateId, ScheduleCandidate candidate, boolean status) {
        this.id = id;
        this.uuid = uuid;
        this.position = position;
        this.remark = remark;
        this.meetingDate = meetingDate;
        this.hrId = hrId;
        this.candidateId = candidateId;
        this.candidate = candidate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ScheduleCandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(ScheduleCandidate candidate) {
        this.candidate = candidate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ScheduleAllResponse{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", position='" + position + '\'' +
                ", remark='" + remark + '\'' +
                ", meetingDate='" + meetingDate + '\'' +
                ", hrId=" + hrId +
                ", candidateId=" + candidateId +
                ", candidate=" + candidate +
                ", status=" + status +
                '}';
    }
}
