package com.app.covw.bean;

import java.io.Serializable;


public class ClassManagerBean implements Serializable {
    private int _id;
    private String class_number;
    private String class_name;
    private String class_techer_number;
    private String class_time;


    public ClassManagerBean(int _id, String class_number, String class_name, String class_techer_number, String class_time) {
        this._id = _id;
        this.class_number = class_number;
        this.class_name = class_name;
        this.class_techer_number = class_techer_number;
        this.class_time = class_time;
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

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_techer_number() {
        return class_techer_number;
    }

    public void setClass_techer_number(String class_techer_number) {
        this.class_techer_number = class_techer_number;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }
}
