package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Album {

    private Integer id;
    private String title;
    private String cover;
    private String author;
    private String score;
    private String broadcast;
    private String count;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date crea_date;

    public Album() {
    }

    public Album(Integer id, String title, String cover, String author, String score, String broadcast, String count, String content, Date crea_date) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.author = author;
        this.score = score;
        this.broadcast = broadcast;
        this.count = count;
        this.content = content;
        this.crea_date = crea_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCrea_date() {
        return crea_date;
    }

    public void setCrea_date(Date crea_date) {
        this.crea_date = crea_date;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", score='" + score + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", count='" + count + '\'' +
                ", content='" + content + '\'' +
                ", crea_date=" + crea_date +
                '}';
    }
}
