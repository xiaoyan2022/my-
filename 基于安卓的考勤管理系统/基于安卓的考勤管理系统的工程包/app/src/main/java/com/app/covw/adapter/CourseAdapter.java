package com.app.covw.adapter;

import com.app.covw.R;
import com.app.covw.bean.CourseBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;


public class CourseAdapter extends BaseQuickAdapter<CourseBean, BaseViewHolder> {


    public CourseAdapter() {
        super(R.layout.salary_item_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, CourseBean courseBean) {
        baseViewHolder.setText(R.id.course_number, "课程编号：" + courseBean.getCourse_number() + "");
        baseViewHolder.setText(R.id.course_name, "课程名称：" + courseBean.getCourse_name());
        baseViewHolder.setText(R.id.course_teacher, "任课老师：" + courseBean.getCourse_teacher());
        baseViewHolder.setText(R.id.course_time, "登记时间：" + courseBean.getCourse_time());
    }
}
