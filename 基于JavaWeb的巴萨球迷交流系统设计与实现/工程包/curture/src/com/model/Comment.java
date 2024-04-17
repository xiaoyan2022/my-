package com.model;

import java.sql.Date;

public class Comment {
    private int cid;
    private int cno;
    private int author;
    private String content;
    private Date date;
    private String name;

    public Comment() {
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public Comment(int cno, int author, String content, Date date) {
        this.cno = cno;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment(int cid, int cno, int author, String content, Date date,String name) {
        this.cid = cid;
        this.cno = cno;
        this.author = author;
        this.content = content;
        this.date = date;
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
}
