package com.app.covw.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.bean.UserInfo;
import com.app.covw.dao.StudioDao;
import com.app.covw.dao.UserDao;
import com.app.covw.utils.SPUtils;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {
    private UserDao mUserInfoDao;
    private AppCompatEditText et_user_name, et_user_pswd;
    private AppCompatTextView btn_register;
    private boolean identity;
    private StudioDao mStudioDao;
    private Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        et_user_name = findViewById(R.id.et_user_name);
        et_user_pswd = findViewById(R.id.et_user_pswd);
        btn_register = findViewById(R.id.btn_register);
        toolbar = findViewById(R.id.toolbar);


        if (mUserInfoDao == null) {
            mUserInfoDao = new UserDao(this);
        }
    }

    @Override
    protected void setListener() {
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Main2Activity.class));
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_user_name.getText().toString().trim();
                String pswd = et_user_pswd.getText().toString().trim();
                if (identity) {
                    if (TextUtils.isEmpty(name)) {
                        BastToast("请输入用户名");
                    } else if (TextUtils.isEmpty(pswd)) {
                        BastToast("请输入密码");
                    } else {
                        UserInfo info = mUserInfoDao.queryAll(name);
                        if (info == null) {
                            BastToast("请先注册");
                        } else {
                            if (info != null && info.getUserName().equals(name) && info.getPassword().equals(pswd)) {
                                SPUtils.saveObject(LoginActivity.this, "userInfo", info);
                                BastToast("登录成功");
                                startActivity(new Intent(LoginActivity.this, Main2Activity.class));
                                Intent intent = new Intent();
                                setResult(IdentityActivity.REQUEST_CODE, intent);
                                finish();
                            } else {
                                BastToast("用户名或密码错误");
                            }
                        }
                    }

                } else {
                    if (TextUtils.isEmpty(name)) {
                        BastToast("请输入工号");
                    } else {
                        if (mStudioDao == null) {
                            mStudioDao = new StudioDao(LoginActivity.this);
                        }
                        StudentBean query = mStudioDao.query(et_user_name.getText().toString().trim());
                        if (query == null) {
                            BastToast("请先让管理员添加学生信息");
                        } else {
                            Intent intent = new Intent(LoginActivity.this, InformationActivity.class);
                            intent.putExtra("info", query);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        identity = intent.getBooleanExtra("identity", false);
        if (identity) {
            btn_register.setVisibility(View.VISIBLE);
            et_user_pswd.setVisibility(View.VISIBLE);
            toolbar.setTitle("管理员登录");
            et_user_name.setHint("请输入用户名");
        } else {
            et_user_name.setHint("请输入学生编号");
            toolbar.setTitle("学生登录");
            btn_register.setVisibility(View.GONE);
            et_user_pswd.setVisibility(View.GONE);
        }
    }
}