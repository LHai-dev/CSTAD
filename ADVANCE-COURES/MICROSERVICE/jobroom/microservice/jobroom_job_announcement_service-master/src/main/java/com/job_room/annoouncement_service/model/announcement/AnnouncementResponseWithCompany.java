package com.job_room.annoouncement_service.model.announcement;

import com.job_room.annoouncement_service.model.consume_model.Company;

import java.util.Map;

public class AnnouncementResponseWithCompany {
    private int id;

    private String uuid;
    private String position;
    private String caption;
    private Map<String,Object> form;
    private String createdDate;
    private String publishedDate;
    private String closedDate;
    private String thumbnail;
    private String image;
    private int companyId;
    private Company company;
    private int candidateCount;

    private boolean isShared;
    private boolean isBanned;
    private boolean isDraft;

    private boolean status;
    public AnnouncementResponseWithCompany(){}

    public AnnouncementResponseWithCompany(int id, String uuid, String position, String caption, Map<String, Object> form, String createdDate, String publishedDate, String closedDate, String thumbnail, String image, int companyId, Company company, int candidateCount, boolean isShared, boolean isBanned, boolean isDraft, boolean status) {
        this.id = id;
        this.uuid = uuid;
        this.position = position;
        this.caption = caption;
        this.form = form;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.closedDate = closedDate;
        this.thumbnail = thumbnail;
        this.image = image;
        this.companyId = companyId;
        this.company = company;
        this.candidateCount = candidateCount;
        this.isShared = isShared;
        this.isBanned = isBanned;
        this.isDraft = isDraft;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Map<String, Object> getForm() {
        return form;
    }

    public void setForm(Map<String, Object> form) {
        this.form = form;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(int candidateCount) {
        this.candidateCount = candidateCount;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
