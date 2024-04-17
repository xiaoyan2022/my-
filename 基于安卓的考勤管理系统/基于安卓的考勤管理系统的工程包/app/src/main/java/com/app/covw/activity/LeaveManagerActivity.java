package com.app.covw.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covw.R;
import com.app.covw.adapter.LeaveManagerAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.LeaveManagerBean;
import com.app.covw.dao.LeaveManagerDao;
import com.app.covw.view.DelateDialog;
import com.app.covw.view.ExamineDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

/**
 * 请假管理
 */
public class LeaveManagerActivity extends BaseActivity {
    public static final int CODE = 200;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private LeaveManagerAdapter mLeaveManagerAdapter;
    private LeaveManagerDao mLeaveManagerDao;
    private DelateDialog mDelateDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_staff_manager;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mLeaveManagerAdapter = new LeaveManagerAdapter();
        mRecyclerView.setAdapter(mLeaveManagerAdapter);

        if (mLeaveManagerDao == null) {
            mLeaveManagerDao = new LeaveManagerDao(this);
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



        mLeaveManagerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
//                Intent intent = new Intent(LeaveManagerActivity.this, UpdateLeaveManagerActivity.class);
//                intent.putExtra("info", mLeaveManagerDao.queryAll().get(position));
//                startActivityForResult(intent, CODE);
                LeaveManagerBean info = mLeaveManagerDao.queryAll().get(position);
                ExamineDialog examineDialog = new ExamineDialog(LeaveManagerActivity.this);
                examineDialog.setDelateListener(new ExamineDialog.ExamineListener() {
                    @Override
                    public void agree() {
                        mLeaveManagerDao.update(info.get_id() + "", "同意");
                        mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
                        examineDialog.dismiss();
                    }

                    @Override
                    public void disagree() {
                        mLeaveManagerDao.update(info.get_id() + "", "不同意");
                        mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
                        examineDialog.dismiss();

                    }
                });

                examineDialog.show();


            }
        });

        mLeaveManagerAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (mDelateDialog == null) {
                    mDelateDialog = new DelateDialog(LeaveManagerActivity.this);
                }
                mDelateDialog.setDelateListener(new DelateDialog.DelateListener() {
                    @Override
                    public void delate() {
                        int delete = mLeaveManagerDao.delete(mLeaveManagerDao.queryAll().get(position).get_id() + "");
                        if (delete == 1) {
                            BastToast("删除成功");
                            mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
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
                mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
                hiddenDialog();
            }
        }, 200);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == CODE) {
            mLeaveManagerAdapter.setNewInstance(mLeaveManagerDao.queryAll());
        }
    }
}