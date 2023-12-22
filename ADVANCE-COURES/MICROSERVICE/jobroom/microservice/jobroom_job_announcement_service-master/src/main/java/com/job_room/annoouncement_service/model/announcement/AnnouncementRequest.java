package com.job_room.annoouncement_service.model.announcement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class AnnouncementRequest {

    @JsonIgnore
    private int id;

    @NotBlank(message = "Position cannot be empty")
    private String position;


    @NotBlank(message = "Caption cannot be empty")
    private String caption;

    private Map<String,Object> form;

    @NotBlank(message = "Published date cannot be empty")
    private String publishedDate;

    @NotBlank(message = "Closed date cannot be empty")
    private String closedDate;

    @NotBlank(message = "Thumbnail cannot be empty")
    private String thumbnail;

    private String image;

    @NotNull(message = "Company Id cannot be empty")
    private int companyId;

    private boolean isShared;
    private boolean isBanned;
    private boolean isDraft;

    @JsonIgnore
    private boolean status;

    public AnnouncementRequest() {
    }

    public AnnouncementRequest(int id, String position, String caption, Map<String, Object> form, String publishedDate, String closedDate, String thumbnail, String image, boolean isShared, boolean isBanned, boolean isDraft, int companyId, boolean status) {
        this.id = id;
        this.position = position;
        this.caption = caption;
        this.form = form;
        this.publishedDate = publishedDate;
        this.closedDate = closedDate;
        this.thumbnail = thumbnail;
        this.image = image;
        this.isShared = isShared;
        this.isBanned = isBanned;
        this.isDraft = isDraft;
        this.companyId = companyId;
        this.status = status;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
