package com.app.covw.bean;

import java.io.Serializable;


public class UserInfo implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String nikename;
    private String signature;

    private  String credit;
    private  String home;
    private  String hometown;
    private  String professional;
    private  String status;
    private String school;
    private String school_scl;


    public UserInfo(int id, String userName, String password, String nikename, String signature, String credit, String home, String hometown, String professional, String status, String school, String school_scl) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nikename = nikename;
        this.signature = signature;
        this.credit = credit;
        this.home = home;
        this.hometown = hometown;
        this.professional = professional;
        this.status = status;
        this.school = school;
        this.school_scl = school_scl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool_scl() {
        return school_scl;
    }

    public void setSchool_scl(String school_scl) {
        this.school_scl = school_scl;
    }
}
