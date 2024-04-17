package com.app.covw.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.app.covw.R;
import com.app.covw.adapter.SignAdapter;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.SignBean;
import com.app.covw.dao.SignDao;
import com.app.covw.view.DelateDialog;
import com.app.covw.view.ExamineDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

/**
 * 签到管理
 */
public class SignActivity extends BaseActivity {
    static final int CODE = 200;
    private Toolbar mToolbar;
    private SignDao mSignDao;
    private RecyclerView mRecyclerView;
    private SignAdapter mSignAdapter;
    private DelateDialog mDelateDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
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
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.add_push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(SignActivity.this, AddSignActivity.class), CODE);
            }
        });

        mSignAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
//                Intent intent = new Intent(SignActivity.this, UpdateSignActivity.class);
//                intent.putExtra("info", mSignDao.queryAll().get(position));
//                startActivityForResult(intent, CODE);
                SignBean signBean = mSignDao.queryAll().get(position);
                ExamineDialog examineDialog = new ExamineDialog(SignActivity.this);
                examineDialog.setDelateListener(new ExamineDialog.ExamineListener() {
                    @Override
                    public void agree() {

                        mSignDao.update(signBean.get_id() + "", "同意");
                        mSignAdapter.setNewInstance(mSignDao.queryAll());
                        examineDialog.dismiss();

                    }

                    @Override
                    public void disagree() {
                        mSignDao.update(signBean.get_id() + "", "不同意");
                        mSignAdapter.setNewInstance(mSignDao.queryAll());
                        examineDialog.dismiss();
                    }
                });

                examineDialog.show();


            }
        });

        mSignAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (mDelateDialog == null) {
                    mDelateDialog = new DelateDialog(SignActivity.this);
                }
                mDelateDialog.setDelateListener(new DelateDialog.DelateListener() {
                    @Override
                    public void delate() {
                        int delete = mSignDao.delete(mSignDao.queryAll().get(position).get_id() + "");
                        if (delete == 1) {
                            BastToast("删除成功");
                            mSignAdapter.setNewInstance(mSignDao.queryAll());
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
                mSignAdapter.setNewInstance(mSignDao.queryAll());
                hiddenDialog();
            }
        }, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == CODE) {
            mSignAdapter.setNewInstance(mSignDao.queryAll());
        }
    }
}