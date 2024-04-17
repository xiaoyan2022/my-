package com.app.covw.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.StudioDao;
import com.app.covw.mine.MyLeaveActivity;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AddStudentActivity extends BaseActivity {
    private Toolbar mToolbar;
    private StudioDao mStudioDao;
    private AppCompatEditText student_number, student_name, class_number;
    private AppCompatTextView student_time;
    private TimePickerView pvCustomTime;   //年月日

    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String spinnerItemStr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_student;
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

        if (mStudioDao == null) {
            mStudioDao = new StudioDao(this);
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

        student_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCustomTime.show();
            }
        });


        findViewById(R.id.add_push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = student_number.getText().toString().trim();
                String name = student_name.getText().toString().trim();
                String cls_num = class_number.getText().toString().trim();
                String time = student_time.getText().toString().trim();
                if (TextUtils.isEmpty(number)) {
                    BastToast("请输入工号");
                } else if (TextUtils.isEmpty(name)) {
                    BastToast("请输入姓名");
                } else if (TextUtils.isEmpty(cls_num)) {
                    BastToast("请输入班级编号");
                } else if (TextUtils.isEmpty(time)) {
                    BastToast("请输入时间");
                } else {
                    int insert = mStudioDao.insert(number, name, cls_num, spinnerItemStr, time);
                    if (insert != -1) {
                        BastToast("添加成功");
                        Intent intent = new Intent();
                        setResult(StudentActivity.CODE, intent);
                        finish();
                    } else {
                        BastToast("添加失败");
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        initCustomTimePicker();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


    public void initCustomTimePicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2060, 2, 28);

        pvCustomTime = new TimePickerBuilder(AddStudentActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                student_time.setText(getTime(date));
            }
        })
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

}