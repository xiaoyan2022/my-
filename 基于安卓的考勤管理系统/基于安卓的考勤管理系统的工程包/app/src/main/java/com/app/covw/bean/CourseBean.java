package com.app.covw.bean;

import java.io.Serializable;


public class CourseBean implements Serializable {

    private int _id;
    private String course_number;
    private String course_name;
    private String course_teacher;
    private String course_time;


    public CourseBean(int _id, String course_number, String course_name, String course_teacher, String course_time) {
        this._id = _id;
        this.course_number = course_number;
        this.course_name = course_name;
        this.course_teacher = course_teacher;
        this.course_time = course_time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(String course_teacher) {
        this.course_teacher = course_teacher;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }
}
