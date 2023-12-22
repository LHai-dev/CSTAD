package com.job_room.hr_ervice.rest.message;

import com.job_room.hr_ervice.model.announcement.AnnouncementResponse;
import com.job_room.hr_ervice.model.company.CompanyResponse;

import java.util.List;

public class CompanyAnnouncement {

    private CompanyResponse companyResponse;
    private List<AnnouncementResponse> announcementResponseList;

    public CompanyAnnouncement() {
    }

    public CompanyAnnouncement(CompanyResponse companyResponse, List<AnnouncementResponse> announcementResponseList) {
        this.companyResponse = companyResponse;
        this.announcementResponseList = announcementResponseList;
    }

    public CompanyResponse getCompanyResponse() {
        return companyResponse;
    }

    public void setCompanyResponse(CompanyResponse companyResponse) {
        this.companyResponse = companyResponse;
    }

    public List<AnnouncementResponse> getAnnouncementResponseList() {
        return announcementResponseList;
    }

    public void setAnnouncementResponseList(List<AnnouncementResponse> announcementResponseList) {
        this.announcementResponseList = announcementResponseList;
    }
}
