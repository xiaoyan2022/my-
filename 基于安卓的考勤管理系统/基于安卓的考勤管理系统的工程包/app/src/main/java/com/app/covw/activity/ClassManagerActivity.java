package com.app.covw.activity;


import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.ClassManagerAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.ClassManagerDao;
import com.app.covw.view.DelateDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

/**
 * 班级管理
 */
public class ClassManagerActivity extends BaseActivity {
    public static final int RESUT_CODE = 200;
    private ClassManagerDao mClassManagerDao;
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    //
    private ClassManagerAdapter mClassManagerAdapter;
    private DelateDialog mDelateDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_recruitment_activity;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mClassManagerAdapter = new ClassManagerAdapter();
        mRecyclerView.setAdapter(mClassManagerAdapter);
        if (mClassManagerDao == null) {
            mClassManagerDao = new ClassManagerDao(this);
        }
        showLoading();
    }

    @Override
    protected void setListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_recruitment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ClassManagerActivity.this, AddClassManagerActivity.class), RESUT_CODE);
            }
        });

        mClassManagerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(ClassManagerActivity.this, UpdateClassManagerActivity.class);
                intent.putExtra("info", mClassManagerDao.queryAll().get(position));
                startActivityForResult(intent, 200);
            }
        });

        mClassManagerAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (mDelateDialog == null) {
                    mDelateDialog = new DelateDialog(ClassManagerActivity.this);
                }
                mDelateDialog.setDelateListener(new DelateDialog.DelateListener() {
                    @Override
                    public void delate() {
                        int delete = mClassManagerDao.delete(mClassManagerDao.queryAll().get(position).get_id() + "");
                        if (delete == 1) {
                            BastToast("删除成功");
                            mClassManagerAdapter.setNewInstance(mClassManagerDao.queryAll());
                        } else {
                            BastToast("删除失败");
                        }
                        mDelateDialog.dismiss();
                    }
                });

                mDelateDialog.show();

                return false;
            }
        });

    }

    @Override
    protected void initData() {
        setAdapter();
    }

    public void setAdapter() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hiddenDialog();
                mClassManagerAdapter.setNewInstance(mClassManagerDao.queryAll());
            }
        }, 200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data && resultCode == RESUT_CODE) {
            setAdapter();
        }
    }


}