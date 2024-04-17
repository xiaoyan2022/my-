package com.app.covw.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.CourseAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.CourseDao;
import com.app.covw.view.DelateDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

/**
 * 课程管理
 */
public class CourseActivity extends BaseActivity {
    public static final int CODE = 200;
    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private CourseDao mCourseDao;
    private CourseAdapter mCourseAdapter;
    private DelateDialog mDelateDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_course;
    }

    @Override
    protected void initViews() {
        if (mCourseDao == null) {
            mCourseDao = new CourseDao(this);
        }
        mToolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        mCourseAdapter = new CourseAdapter();
        recyclerView.setAdapter(mCourseAdapter);
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

        findViewById(R.id.add_push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(CourseActivity.this, AddCourseActivity.class), CODE);
            }
        });
        mCourseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(CourseActivity.this, UpdateCourseActivity.class);
                intent.putExtra("info", mCourseDao.queryAll().get(position));
                startActivityForResult(intent, CODE);
            }
        });

        mCourseAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (mDelateDialog == null) {
                    mDelateDialog = new DelateDialog(CourseActivity.this);
                }
                mDelateDialog.setDelateListener(new DelateDialog.DelateListener() {
                    @Override
                    public void delate() {
                        int delete = mCourseDao.delete(mCourseDao.queryAll().get(position).get_id() + "");
                        if (delete == 1) {
                            BastToast("删除成功");
                            mCourseAdapter.setNewInstance(mCourseDao.queryAll());
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCourseAdapter.setNewInstance(mCourseDao.queryAll());
                hiddenDialog();
            }
        }, 200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == CODE) {
            mCourseAdapter.setNewInstance(mCourseDao.queryAll());
        }
    }
}