package com.app.covw.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.dao.ClassManagerDao;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddClassManagerActivity extends BaseActivity {
    private Toolbar mToolbar;
    private AppCompatEditText class_number, class_name, class_techer_number;
    private AppCompatTextView class_time;
    private ClassManagerDao mClassManagerDao;
    private TimePickerView pvCustomTime;   //年月日

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_class_manager;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        class_number = findViewById(R.id.class_number);
        class_name = findViewById(R.id.class_name);
        class_techer_number = findViewById(R.id.class_techer_number);
        class_time = findViewById(R.id.class_time);
        if (mClassManagerDao == null) {
            mClassManagerDao = new ClassManagerDao(this);
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

        class_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCustomTime.show();
            }
        });

        findViewById(R.id.btn_publish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(class_number.getText().toString().trim())) {
                    BastToast("请输入班级编号");
                } else if (TextUtils.isEmpty(class_name.getText().toString().trim())) {
                    BastToast("请输入班级名称");
                } else if (TextUtils.isEmpty(class_techer_number.getText().toString().trim())) {
                    BastToast("请输入教师编号");
                } else if (TextUtils.isEmpty(class_time.getText().toString().trim())) {
                    BastToast("请输入登记时间");
                } else {
                    if (null != mClassManagerDao) {
                        int insert = mClassManagerDao.insert(
                                class_number.getText().toString(),
                                class_name.getText().toString(),
                                class_techer_number.getText().toString(),
                                class_time.getText().toString());
                        if (insert != -1) {
                            BastToast("发布成功");
                            Intent intent = new Intent();
                            setResult(ClassManagerActivity.RESUT_CODE, intent);
                            finish();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        initCustomTimePicker();
    }

    public void initCustomTimePicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2060, 2, 28);

        pvCustomTime = new TimePickerBuilder(AddClassManagerActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                class_time.setText(getTime(date));
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