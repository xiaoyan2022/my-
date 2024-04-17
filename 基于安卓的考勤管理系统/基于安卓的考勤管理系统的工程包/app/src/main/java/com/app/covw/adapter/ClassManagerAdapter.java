package com.app.covw.adapter;

import com.app.covw.R;
import com.app.covw.bean.ClassManagerBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class ClassManagerAdapter extends BaseQuickAdapter<ClassManagerBean, BaseViewHolder> {


    public ClassManagerAdapter() {
        super(R.layout.recruit_ment_item_layout);

    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, ClassManagerBean item) {
        helper.setText(R.id.class_number, item.getClass_number());
        helper.setText(R.id.class_name, item.getClass_name());
        helper.setText(R.id.class_techer_number, item.getClass_techer_number());
        helper.setText(R.id.class_time, item.getClass_time());
    }


}
