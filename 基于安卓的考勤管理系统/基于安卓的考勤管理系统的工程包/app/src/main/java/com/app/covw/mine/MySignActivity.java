package com.app.covw.mine;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.SignAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.SignDao;


public class MySignActivity extends BaseActivity {

    private Toolbar mToolbar;
    private StudentBean user;

    private SignDao mSignDao;
    private RecyclerView mRecyclerView;
    private SignAdapter mSignAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_sign;
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


        mRecyclerView = findViewById(R.id.recyclerView);

        mSignAdapter = new SignAdapter();
        mRecyclerView.setAdapter(mSignAdapter);

        if (mSignDao == null) {
            mSignDao = new SignDao(this);
        }
        showLoading();

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        user = (StudentBean) getIntent().getSerializableExtra("user");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSignAdapter.setNewInstance(mSignDao.queryAll());
                hiddenDialog();
            }
        }, 200);
    }

    public void btnAddSign(View view) {
        Intent intent = new Intent(MySignActivity.this, AddMySignActivity.class);
        intent.putExtra("user", user);
        startActivityForResult(intent, 200);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == 200) {
            mSignAdapter.setNewInstance(mSignDao.queryAll());
        }
    }
}