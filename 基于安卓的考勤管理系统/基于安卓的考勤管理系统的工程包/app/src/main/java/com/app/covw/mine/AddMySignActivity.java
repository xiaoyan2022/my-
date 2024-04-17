package com.app.covw.mine;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.SignDao;
import com.app.covw.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class AddMySignActivity extends BaseActivity {
    private StudentBean user;
    private Toolbar mToolbar;
    private AppCompatTextView class_number, student_number, student_name;
    private AppCompatEditText course_number;

    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String spinnerItemStr;


    //
    private SignDao mSignDao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_my_sign;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        class_number = findViewById(R.id.class_number);
        course_number =findViewById(R.id.course_number);
        student_number = findViewById(R.id.student_number);
        student_name = findViewById(R.id.student_name);
        spinner = findViewById(R.id.spinner);
        list.add("出勤");
        list.add("请假");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (mSignDao == null) {
            mSignDao = new SignDao(this);
        }

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


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        user = (StudentBean) getIntent().getSerializableExtra("user");
        if (null != user) {
            class_number.setText(user.getClass_number());
            student_number.setText(user.getStudent_number());
            student_name.setText(user.getStudent_name());
        }

    }

    public void save(View view) {

        String course_num =course_number.getText().toString().trim();
        if (TextUtils.isEmpty(course_num)){
            BastToast("请选择课程编号");
        }else {
            int insert = mSignDao.insert(user.getClass_number(), user.getStudent_number(), user.getStudent_name(), spinnerItemStr, "等待审核", DataUtils.getCurrentData(),course_num);
            if (insert != -1) {
                BastToast("提交成功，等待审批");
                Intent intent = new Intent();
                setResult(200, intent);
                finish();
            } else {
                BastToast("提交失败");
            }
        }


    }

}