package com.app.covw.mine;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.LeaveManagerAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.LeaveManagerDao;

/**
 * 我要请假
 */
public class MyLeaveActivity extends BaseActivity {
    private RecyclerView mRecyclerView;

    private LeaveManagerAdapter mLeaveManagerAdapter;
    private LeaveManagerDao mLeaveManagerDao;
    private Toolbar mToolbar;
    private StudentBean user;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_leave;
    }

    @Override
    protected void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLeaveManagerAdapter = new LeaveManagerAdapter();
        mRecyclerView.setAdapter(mLeaveManagerAdapter);
        if (mLeaveManagerDao == null) {
            mLeaveManagerDao = new LeaveManagerDao(this);
        }

        mToolbar = findViewById(R.id.toolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
                hiddenDialog();
            }
        }, 200);


    }


    public void btrnAddLeave(View view) {
        Intent intent = new Intent(this, AddLeaveActivity.class);
        intent.putExtra("user", user);
        startActivityForResult(intent,200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null && resultCode==200){
            mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
        }
    }
}