package com.app.covw.bean;

import java.io.Serializable;

public class SignBean implements Serializable {
    private int _id;
    private String class_number;
    private String student_number;
    private String student_name;
    private String sing_try;
    private String sign_state;
    private String sign_time;
    private String course_number;


    public SignBean(int _id, String class_number, String student_number, String student_name, String sing_try, String sign_state, String sign_time, String course_number) {
        this._id = _id;
        this.class_number = class_number;
        this.student_number = student_number;
        this.student_name = student_name;
        this.sing_try = sing_try;
        this.sign_state = sign_state;
        this.sign_time = sign_time;
        this.course_number = course_number;
    }

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSing_try() {
        return sing_try;
    }

    public void setSing_try(String sing_try) {
        this.sing_try = sing_try;
    }

    public String getSign_state() {
        return sign_state;
    }

    public void setSign_state(String sign_state) {
        this.sign_state = sign_state;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }
}
