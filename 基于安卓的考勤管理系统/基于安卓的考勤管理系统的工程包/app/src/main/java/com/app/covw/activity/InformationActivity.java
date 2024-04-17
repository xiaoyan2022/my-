package com.app.covw.activity;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.mine.MyLeaveActivity;
import com.app.covw.mine.MySignActivity;

public class InformationActivity extends BaseActivity {
    private Toolbar mToolbar;
    private StudentBean bean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_information;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        bean = (StudentBean) getIntent().getSerializableExtra("info");

    }

    public void btn_my_leave(View view) {
        Intent intent = new Intent(this, MyLeaveActivity.class);
        intent.putExtra("user", bean);
        startActivity(intent);
    }

    public void btn_my_sign(View view) {
        Intent intent = new Intent(this, MySignActivity.class);
        intent.putExtra("user", bean);
        startActivity(intent);
    }


}