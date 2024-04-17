package com.app.covw.bean;

import java.io.Serializable;


public class StudentBean implements Serializable {
    private int _id;
    private String student_number;
    private String student_name;
    private String class_number;
    private String student_state;
    private String student_time;


    public StudentBean(int _id, String student_number, String student_name, String class_number, String student_state, String student_time) {
        this._id = _id;
        this.student_number = student_number;
        this.student_name = student_name;
        this.class_number = class_number;
        this.student_state = student_state;
        this.student_time = student_time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getStudent_state() {
        return student_state;
    }

    public void setStudent_state(String student_state) {
        this.student_state = student_state;
    }

    public String getStudent_time() {
        return student_time;
    }

    public void setStudent_time(String student_time) {
        this.student_time = student_time;
    }
}
