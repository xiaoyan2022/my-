package com.app.covw.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.UserInfo;
import com.app.covw.utils.SPUtils;

public class CenterActivity extends BaseActivity {
    private TextView username, signature, credit, home, hometown, professional, status, school, school_scl;
    private TextView edit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_center;
    }

    @Override
    protected void initViews() {

        signature = findViewById(R.id.signature);
        username = findViewById(R.id.username);
        edit = findViewById(R.id.edit);
        credit = findViewById(R.id.credit);
        home = findViewById(R.id.home);
        hometown = findViewById(R.id.hometown);
        professional = findViewById(R.id.professional);
        status = findViewById(R.id.status);
        school = findViewById(R.id.school);
        school_scl = findViewById(R.id.school_scl);

    }

    @Override
    protected void setListener() {

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, EditActivity.class);
                startActivityForResult(intent, 200);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData() {

        UserInfo info = SPUtils.getObject(this, "userInfo", UserInfo.class);
        if (null != info) {
            signature.setText("个性签名：" + info.getSignature());
            username.setText("用户名：" + info.getUserName());
            credit.setText("信用：" + info.getCredit());
            home.setText("所在地：" + info.getHome());
            hometown.setText("家乡：" + info.getHometown());
            professional.setText("职业：" + info.getProfessional());
            status.setText("感情状况：" + info.getStatus());
            school.setText("学校：" + info.getSchool());
            school_scl.setText("专业：" + info.getSchool_scl());
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data && resultCode == 200) {
            initData();
        }
    }
}