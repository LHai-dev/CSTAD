package com.job_room.hr_ervice.model.announcement;

import java.util.Map;

public class AnnouncementResponse {

    private int id;
    private String uuid;
    private String position;
    private String caption;
    private Map<String,Object> form;
    private String created_date;
    private String published_date;
    private String closed_date;
    private String thumbnail;
    private String image;
    private int companyId;
    private boolean is_shared;


    private boolean status;

    public AnnouncementResponse() {
    }

    public AnnouncementResponse(int id, String uuid, String position, String caption, Map<String, Object> form, String created_date, String published_date, String closed_date, String thumbnail, String image, int companyId , boolean is_shared, boolean status) {
        this.id = id;
        this.uuid = uuid;
        this.position = position;
        this.caption = caption;
        this.form = form;
        this.created_date = created_date;
        this.published_date = published_date;
        this.closed_date = closed_date;
        this.thumbnail = thumbnail;
        this.image = image;
        this.is_shared = is_shared;
        this.companyId = companyId;
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

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(String closed_date) {
        this.closed_date = closed_date;
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

    public boolean isIs_shared() {
        return is_shared;
    }

    public void setIs_shared(boolean is_shared) {
        this.is_shared = is_shared;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnnouncementResponse{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", position='" + position + '\'' +
                ", caption='" + caption + '\'' +
                ", form=" + form +
                ", created_date='" + created_date + '\'' +
                ", published_date='" + published_date + '\'' +
                ", closed_date='" + closed_date + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", companyId=" + companyId +
                ", is_shared=" + is_shared +
                ", status=" + status +
                '}';
    }
}
