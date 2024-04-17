package com.app.covw.adapter;

import android.graphics.Color;
import android.widget.TextView;

import com.app.covw.R;
import com.app.covw.bean.StudentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;


public class StudentAdapter extends BaseQuickAdapter<StudentBean, BaseViewHolder> {
    public StudentAdapter() {
        super(R.layout.student_item_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, StudentBean studentBean) {
        holder.setText(R.id.student_number, "学号：" + studentBean.getStudent_number());
        holder.setText(R.id.student_name, "姓名：" + studentBean.getStudent_name());
        holder.setText(R.id.class_number, "班级编号：" + studentBean.getClass_number());
        holder.setText(R.id.student_state, studentBean.getStudent_state());
        holder.setText(R.id.student_time, "登记时间：" + studentBean.getStudent_time());


        if (studentBean.getStudent_state().equals("在校")) {
            ((TextView) holder.getView(R.id.student_state)).setTextColor(Color.parseColor("#009688"));
        } else {
            ((TextView) holder.getView(R.id.student_state)).setTextColor(Color.parseColor("#E44848"));
        }
    }
}
