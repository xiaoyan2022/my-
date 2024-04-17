package com.app.covw.bean;

import java.io.Serializable;


public class LeaveManagerBean implements Serializable {
   private int _id;
   private String leave_number;
   private String student_name;
   private String leave_start_time;
   private String leave_end_time;
   private String leave_why;
   private String student_state;

    public LeaveManagerBean(int _id, String leave_number, String student_name, String leave_start_time, String leave_end_time, String leave_why, String student_state) {
        this._id = _id;
        this.leave_number = leave_number;
        this.student_name = student_name;
        this.leave_start_time = leave_start_time;
        this.leave_end_time = leave_end_time;
        this.leave_why = leave_why;
        this.student_state = student_state;
    }

    public String getLeave_why() {
        return leave_why;
    }

    public void setLeave_why(String leave_why) {
        this.leave_why = leave_why;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLeave_number() {
        return leave_number;
    }

    public void setLeave_number(String leave_number) {
        this.leave_number = leave_number;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getLeave_start_time() {
        return leave_start_time;
    }

    public void setLeave_start_time(String leave_start_time) {
        this.leave_start_time = leave_start_time;
    }

    public String getLeave_end_time() {
        return leave_end_time;
    }

    public void setLeave_end_time(String leave_end_time) {
        this.leave_end_time = leave_end_time;
    }

    public String getStudent_state() {
        return student_state;
    }

    public void setStudent_state(String student_state) {
        this.student_state = student_state;
    }
}
