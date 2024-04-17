package com.app.covw.activity;

import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.UserDao;


/**
 * 注册
 */

public class RegisterActivity extends BaseActivity {
    private static final String TAG = "RegisterActivity";
    private Toolbar mToolbar;
    private AppCompatEditText et_user_name, et_user_pswd;
    private UserDao mUserInfoDao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        et_user_name = findViewById(R.id.et_user_name);
        et_user_pswd = findViewById(R.id.et_user_pswd);

        if (mUserInfoDao == null) {
            mUserInfoDao = new UserDao(this);
        }
    }

    @Override
    protected void setListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et_user_name.getText().toString().trim();
                String pawsd = et_user_pswd.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    BastToast("请输入用户名");
                } else if (TextUtils.isEmpty(pawsd)) {
                    BastToast("请输入密码");
                } else {
                    int insert = mUserInfoDao.insert(name, pawsd, "", "今天你微笑了吗", "90分", "上海市", "北京市", "教师", "未婚", "xxx","xxx");

                    if (insert != -1) {
                        BastToast("注册成功");
                        finish();
                    } else {
                        BastToast("注册失败");
                    }
                }
            }
        });

    }
}