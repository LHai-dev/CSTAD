package com.job_room.schedule_service.model.request;

public class CandidateIdRequest {
    private int id;

    public CandidateIdRequest() {
    }

    public CandidateIdRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CandidateIdRequest{" +
                "id=" + id +
                '}';
    }
}
