package com.app.covw.adapter;

import android.graphics.Color;
import android.widget.TextView;

import com.app.covw.R;
import com.app.covw.bean.SignBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;


public class SignAdapter extends BaseQuickAdapter<SignBean, BaseViewHolder> {
    public SignAdapter() {
        super(R.layout.mobility_item_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, SignBean signBean) {
        baseViewHolder.setText(R.id.class_number, "班级编号：" + signBean.getClass_number());
        baseViewHolder.setText(R.id.student_number, "学生编号：" + signBean.getStudent_number());
        baseViewHolder.setText(R.id.student_name, "学生姓名：" + signBean.getStudent_name());
        baseViewHolder.setText(R.id.sign_try, "考勤方式：" + signBean.getSing_try());
        baseViewHolder.setText(R.id.sign_time, "登记时间：" + signBean.getSign_time());
        baseViewHolder.setText(R.id.course_number, "课程编号：" + signBean.getCourse_number());
        baseViewHolder.setText(R.id.sign_state, signBean.getSign_state());

        if (signBean.getSign_state().equals("等待审核")) {
            ((TextView) baseViewHolder.getView(R.id.sign_state)).setTextColor(Color.parseColor("#E44848"));
        } else if (signBean.getSign_state().equals("同意")) {
            ((TextView) baseViewHolder.getView(R.id.sign_state)).setTextColor(Color.parseColor("#009688"));
        } else {
            ((TextView) baseViewHolder.getView(R.id.sign_state)).setTextColor(Color.parseColor("#1479FF"));
        }
    }
}

