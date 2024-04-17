package com.model;

import java.sql.Date;

public class Culture {
    private int cno;
    private String title;
    private String content;
    private int author;
    private Date date;
    private int likes;
    private int dislike;
    private String name;

    private int open;

    public Culture(String title, String content, int author, Date date,int open) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.open = open;
    }

    public Culture(String title, String content, int cno, int open) {
        this.title = title;
        this.content = content;
        this.cno = cno;
        this.open = open;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Culture() {
    }

    public Culture(int cno, String title, String content, int author, Date date, int likes, int dislike, String name,int open) {
        this.cno = cno;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.likes = likes;
        this.dislike = dislike;
        this.name = name;
        this.open = open;
    }

    public Culture(int cno, String title, String content, int author, Date date, int likes, int dislike) {
        this.cno = cno;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.likes = likes;
        this.dislike = dislike;
    }

    public Culture(String title, String content, int author, Date date, int likes, int dislike) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.likes = likes;
        this.dislike = dislike;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }
}
