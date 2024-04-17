package com.app.covw.activity;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.SignBean;
import com.app.covw.dao.SignDao;

import java.util.ArrayList;
import java.util.List;

public class UpdateSignActivity extends BaseActivity {
    private Toolbar mToolbar;
    private SignDao mSignDao;
    private SignBean info;
    private AppCompatTextView class_number, student_number;
    private AppCompatEditText sign_time;

    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String spinnerItemStr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_sign;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        class_number = findViewById(R.id.class_number);
        student_number = findViewById(R.id.student_number);
        sign_time = findViewById(R.id.sign_time);
        spinner = findViewById(R.id.spinner);
        list.add("在校");
        list.add("离校");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void setListener() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerItemStr = list.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData() {

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //
        info = (SignBean) getIntent().getSerializableExtra("info");
        class_number.setText(info.getClass_number() + "");
        student_number.setText(info.getStudent_number() + "");
        sign_time.setText(info.getSign_time() + "");

    }

    public void add_push(View view) {
        String time = sign_time.getText().toString().trim();
        if (mSignDao == null) {
            mSignDao = new SignDao(this);
        }
        int update = mSignDao.update(info.get_id() + "", spinnerItemStr, time);
        if (update != -1) {
            BastToast("修改成功");
            Intent intent = new Intent();
            setResult(SignActivity.CODE, intent);
            finish();
        } else {
            BastToast("修改失败");
        }
    }
}