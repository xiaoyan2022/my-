package com.app.covw.activity;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.CourseBean;
import com.app.covw.dao.CourseDao;

public class UpdateCourseActivity extends BaseActivity {
    private Toolbar mToolbar;
    private CourseBean mCourseBean;
    private CourseDao mCourseDao;

    private AppCompatEditText course_name, course_teacher, course_time;
    private AppCompatTextView course_number;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_salary;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);

        course_number = findViewById(R.id.course_number);
        course_name = findViewById(R.id.course_name);
        course_teacher = findViewById(R.id.course_teacher);
        course_time = findViewById(R.id.course_time);


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void setListener() {

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData() {
        mCourseBean = (CourseBean) getIntent().getSerializableExtra("info");
        if (null!=mCourseBean){
            course_number.setText(mCourseBean.getCourse_number() + "");
            course_name.setText(mCourseBean.getCourse_name());
            course_teacher.setText(mCourseBean.getCourse_teacher() + "");
            course_time.setText(mCourseBean.getCourse_time() + "");
        }
    }

    public void add_push(View view) {
        String name = course_name.getText().toString().trim();
        String teacher = course_teacher.getText().toString().trim();
        String time = course_time.getText().toString().trim();
        if (mCourseDao == null) {
            mCourseDao = new CourseDao(this);

        }
        int update = mCourseDao.update(mCourseBean.get_id()+"", name, teacher, time);
        if (update == 1) {
            BastToast("修改成功");
            Intent intent = new Intent();
            setResult(200, intent);
            finish();
        } else {
            BastToast("修改失败");
        }

    }
}