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
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.StudioDao;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentActivity extends BaseActivity {
    private Toolbar mToolbar;
    private AppCompatTextView student_number, student_name;
    private AppCompatEditText class_number, student_time;
    private StudioDao mStudioDao;
    private StudentBean bean;


    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String spinnerItemStr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_student;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        student_number = findViewById(R.id.student_number);
        student_name = findViewById(R.id.student_name);
        class_number = findViewById(R.id.class_number);
        student_time = findViewById(R.id.student_time);

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


        bean = (StudentBean) getIntent().getSerializableExtra("info");
        if (null != bean) {
            student_number.setText(bean.getStudent_number() + "");
            student_name.setText(bean.getStudent_name());
            class_number.setText(bean.getClass_number());
            student_name.setText(bean.getStudent_name());
            student_time.setText(bean.getStudent_time());
        }

    }

    public void add_push(View view) {
        String cls_num = class_number.getText().toString().trim();
        String stu_time = student_time.getText().toString().trim();
        if (mStudioDao == null) {
            mStudioDao = new StudioDao(this);
        }
        int update = mStudioDao.update(bean.get_id() + "", cls_num, spinnerItemStr, stu_time);
        if (update == 1) {
            BastToast("修改成功");
            Intent intent = new Intent();
            setResult(StudentActivity.CODE, intent);
            finish();
        } else {
            BastToast("修改失败");
        }
    }
}