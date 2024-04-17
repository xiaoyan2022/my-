package com.app.covw.activity;

import android.content.Intent;
import android.view.View;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    /**
     * 个人中心
     *
     * @param view
     */
    public void btnCenter(View view) {

        startActivity(new Intent(this, CenterActivity.class));
    }

    /**
     * 签到
     */
    public void btnSign(View view) {
        startActivity(new Intent(this, SignActivity.class));
    }

    /**
     * 学生管理
     */
    public void btnStudentManager(View view) {
        startActivity(new Intent(this, StudentActivity.class));
    }

    /**
     * 课程管理
     */
    public void courseManager(View view) {
        startActivity(new Intent(this, CourseActivity.class));
    }

    /**
     * 班级管理
     */
    public void btnClassManager(View view) {

        startActivity(new Intent(this, ClassManagerActivity.class));


    }

    /**
     * 请假管理  AddStaffManagerActivity
     */

    public void btnLeaveManager(View view){
        startActivity(new Intent(this, LeaveManagerActivity.class));
    }
}