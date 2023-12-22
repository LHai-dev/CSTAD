package com.job_room.hr_ervice.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class CompanyRequest {

    @JsonIgnore
    private int id;

    @ApiModelProperty(value = "name", position = 1)
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @ApiModelProperty(value = "primary_email", position = 2)
    @NotBlank(message = "Primary email cannot be empty")
    private String primaryEmail;

    @ApiModelProperty(value = "password", position = 3)
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @ApiModelProperty(value = "Secondary email", position = 4)
    @NotBlank(message = "Secondary email cannot be empty")
    private String secondaryEmail;

    @ApiModelProperty(value = "logo", position = 5)
    private String logo;

    @ApiModelProperty(value = "website", position = 6)
    private String website;

    @ApiModelProperty(value = "street", position = 7)
    private String street;

    @ApiModelProperty(value = "street", position = 8)
    private String commune;

    @ApiModelProperty(value = "district", position = 9)
    private String district;

    @ApiModelProperty(value = "city", position = 10)
    private String city;

    @ApiModelProperty(value = "telephone", position = 11)
    private String telephone;

    @ApiModelProperty(value = "status", position = 12)
    private boolean isBanned;

    @ApiModelProperty(value = "status", position = 13)
    private boolean status;

    public CompanyRequest() {
    }

    public CompanyRequest(int id,String name,  String primaryEmail, String password, String secondaryEmail, String logo, String website, String street, String commune, String district, String city, String telephone, boolean isBanned, boolean status) {
        this.id = id;
        this.name = name;
        this.primaryEmail = primaryEmail;
        this.password = password;
        this.secondaryEmail = secondaryEmail;
        this.logo = logo;
        this.website = website;
        this.street = street;
        this.commune = commune;
        this.district = district;
        this.city = city;
        this.telephone = telephone;
        this.isBanned = isBanned;
        this.status = status;
    }


    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CompanyRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", password='" + password + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", logo='" + logo + '\'' +
                ", website='" + website + '\'' +
                ", street='" + street + '\'' +
                ", commune='" + commune + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", isBanned=" + isBanned +
                ", status=" + status +
                '}';
    }
}
