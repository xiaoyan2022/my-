package com.app.covw.adapter;

import android.graphics.Color;
import android.widget.TextView;

import com.app.covw.R;
import com.app.covw.bean.LeaveManagerBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;


public class LeaveManagerAdapter extends BaseQuickAdapter<LeaveManagerBean, BaseViewHolder> {
    public LeaveManagerAdapter() {
        super(R.layout.staff_item_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, LeaveManagerBean item) {
        holder.setText(R.id.leave_number, item.getLeave_number() + "");
        holder.setText(R.id.student_name, item.getStudent_name());
        holder.setText(R.id.leave_start_time, item.getLeave_start_time());
        holder.setText(R.id.leave_end_time, item.getLeave_end_time());
        holder.setText(R.id.student_state, item.getStudent_state());
        holder.setText(R.id.leave_why, item.getLeave_why());

        if (item.getStudent_state().equals("等待审核")) {
            ((TextView) holder.getView(R.id.student_state)).setTextColor(Color.parseColor("#E44848"));
        } else if (item.getStudent_state().equals("同意")) {
            ((TextView) holder.getView(R.id.student_state)).setTextColor(Color.parseColor("#009688"));
        } else {
            ((TextView) holder.getView(R.id.student_state)).setTextColor(Color.parseColor("#1479FF"));
        }
    }
}
