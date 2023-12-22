package com.job_room.annoouncement_service.model.consume_model;

public class Company {
    private int id;
    private String uuid;
    private String name;
    private String primaryEmail;
    private String secondaryEmail;
    private String logo;
    private String website;
    private String street;
    private String commune;
    private String district;
    private String city;
    private String telephone;
    private boolean isBanned;
    private boolean status;
    public Company(){}

    public Company(int id, String uuid, String name, String primaryEmail, String secondaryEmail, String logo, String website, String street, String commune, String district, String city, String telephone, boolean isBanned, boolean status) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.primaryEmail = primaryEmail;
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

    public String getName() {
        return name;
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
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
