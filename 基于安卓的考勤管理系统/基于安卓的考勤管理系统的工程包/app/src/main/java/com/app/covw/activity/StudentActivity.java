package com.app.covw.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.StudentAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.StudioDao;
import com.app.covw.view.DelateDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;


public class StudentActivity extends BaseActivity {
    static final int CODE = 200;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private DelateDialog mDelateDialog;
    private StudentAdapter mStudentAdapter;

    private StudioDao mStudioDao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_student;
    }

    @Override
    protected void initViews() {
        if (mStudioDao == null) {
            mStudioDao = new StudioDao(this);
        }


        mToolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mStudentAdapter = new StudentAdapter();
        mRecyclerView.setAdapter(mStudentAdapter);

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

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(StudentActivity.this, AddStudentActivity.class), CODE);

            }
        });


        mStudentAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(StudentActivity.this, UpdateStudentActivity.class);
                intent.putExtra("info", mStudioDao.queryAll().get(position));
                startActivityForResult(intent, CODE);
            }
        });


        mStudentAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

                StudentBean bean = mStudioDao.queryAll().get(position);
                if (mDelateDialog == null) {
                    mDelateDialog = new DelateDialog(StudentActivity.this);

                }
                mDelateDialog.setDelateListener(new DelateDialog.DelateListener() {
                    @Override
                    public void delate() {
                        int delate = mStudioDao.delate(bean.getStudent_name());
                        if (delate == 1) {
                            BastToast("删除成功");
                        } else {
                            BastToast("删除失败");
                        }
                        mDelateDialog.dismiss();
                        mStudentAdapter.setNewInstance(mStudioDao.queryAll());
                    }
                });

                mDelateDialog.show();


                return false;
            }
        });


    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mStudentAdapter.setNewInstance(mStudioDao.queryAll());
                hiddenDialog();
            }
        }, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == CODE) {
            mStudentAdapter.setNewInstance(mStudioDao.queryAll());
        }

    }
}