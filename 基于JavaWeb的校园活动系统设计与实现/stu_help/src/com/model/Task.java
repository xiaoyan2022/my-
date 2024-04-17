package com.model;

import java.sql.Date;

public class Task {
    private int tid;
    private int pub;
    private String title;
    private String des;
    private Date time;
    private Date end;
    private int reward;
    private int status;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Task() {
    }

    public Task(int pub, String title, String des, Date time, int reward, Date end) {
        this.pub = pub;
        this.title = title;
        this.des = des;
        this.time = time;
        this.reward = reward;
        this.end = end;
    }

    public Task(int tid, int pub, String title, String des, Date time, int reward, int status, Date end) {
        this.tid = tid;
        this.pub = pub;
        this.title = title;
        this.des = des;
        this.time = time;
        this.reward = reward;
        this.status = status;
        this.end = end;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPub() {
        return pub;
    }

    public void setPub(int pub) {
        this.pub = pub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
