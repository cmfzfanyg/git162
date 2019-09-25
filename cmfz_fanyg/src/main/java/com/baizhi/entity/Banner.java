package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Banner {

    private String id;
    private String name;
    private String img_path;
    private String status;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date up_date;

    public Banner() {
    }

    public Banner(String id, String name, String img_path, String status, String description, Date up_date) {
        this.id = id;
        this.name = name;
        this.img_path = img_path;
        this.status = status;
        this.description = description;
        this.up_date = up_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img_path='" + img_path + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", up_date=" + up_date +
                '}';
    }
}
