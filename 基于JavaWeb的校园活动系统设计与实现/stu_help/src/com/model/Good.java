package com.model;

import java.sql.Date;

public class Good {
    private int gid;
    private int owner;
    private String name;
    private String des;
    private Date time;
    private int price;
    private int status;

    public Good() {
    }

    public Good(int owner, String name, String des, Date time) {
        this.owner = owner;
        this.name = name;
        this.des = des;
        this.time = time;
    }

    public Good(int gid, int owner, String name, String des, Date time, int price, int status) {
        this.gid = gid;
        this.owner = owner;
        this.name = name;
        this.des = des;
        this.time = time;
        this.price = price;
        this.status = status;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
