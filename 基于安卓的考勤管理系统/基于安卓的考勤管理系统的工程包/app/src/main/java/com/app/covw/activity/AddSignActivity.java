package com.app.covw.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.SignDao;

import java.util.ArrayList;
import java.util.List;

public class AddSignActivity extends BaseActivity {
    private Toolbar mToolbar;
    private SignDao mSignDao;
    private AppCompatEditText class_number, student_number, sign_time;
    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String spinnerItemStr;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_sign;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        class_number = findViewById(R.id.class_number);
        student_number = findViewById(R.id.student_number);
        spinner = findViewById(R.id.spinner);
        list.add("在校");
        list.add("离校");
        sign_time = findViewById(R.id.sign_time);
        if (mSignDao == null) {
            mSignDao = new SignDao(this);
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


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerItemStr = list.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        findViewById(R.id.add_push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String class_num = class_number.getText().toString().trim();
                String student_num = student_number.getText().toString().trim();
                String time = sign_time.getText().toString().trim();
                if (TextUtils.isEmpty(class_num)) {
                    BastToast("请输入班级编号");
                } else if (TextUtils.isEmpty(student_num)) {
                    BastToast("请输入学生编号");
                } else if (TextUtils.isEmpty(spinnerItemStr)) {
                    BastToast("请输入学生状态");
                } else if (TextUtils.isEmpty(time)) {
                    BastToast("请输入登记时间");
                } else {
//                    int insert = mSignDao.insert(Integer.parseInt(class_num), Integer.parseInt(student_num), spinnerItemStr, time);
//                    if (insert != -1) {
//                        BastToast("添加成功");
//                        Intent intent = new Intent();
//                        setResult(SignActivity.CODE, intent);
//                        finish();
//                    } else {
//                        BastToast("添加失败");
//                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}