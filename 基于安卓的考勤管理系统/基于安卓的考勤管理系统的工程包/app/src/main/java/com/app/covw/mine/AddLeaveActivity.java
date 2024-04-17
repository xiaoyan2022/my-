package com.app.covw.mine;

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
import com.app.covw.bean.StudentBean;
import com.app.covw.dao.LeaveManagerDao;
import com.app.covw.db.LeaveManagerDb;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddLeaveActivity extends BaseActivity {
    private LeaveManagerDao mLeaveManagerDao;
    private Toolbar mToolbar;
    private StudentBean user;
    private AppCompatTextView student_number, class_number, student_name;
    private AppCompatTextView start_time, end_time;
    private AppCompatEditText tv_why;

    private TimePickerView pvCustomTime;   //年月日

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_leave;
    }

    @Override
    protected void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        student_number = findViewById(R.id.student_number);
        student_name = findViewById(R.id.student_name);
        class_number = findViewById(R.id.class_number);
        tv_why = findViewById(R.id.tv_why);
        start_time = findViewById(R.id.start_time);
        end_time = findViewById(R.id.end_time);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCustomTime.show(start_time);
            }
        });

        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCustomTime.show(end_time);
            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        initCustomTimePicker();
        user = (StudentBean) getIntent().getSerializableExtra("user");
        if (null != user) {
            student_number.setText(user.getStudent_number());
            class_number.setText(user.getClass_number());
            student_name.setText(user.getStudent_name());
        }
    }

    public void initCustomTimePicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2060, 2, 28);

        pvCustomTime = new TimePickerBuilder(AddLeaveActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                ((AppCompatTextView) v).setText(getTime(date));
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

    public void btnAdd(View view) {
        if (mLeaveManagerDao == null) {
            mLeaveManagerDao = new LeaveManagerDao(AddLeaveActivity.this);
        }
        String thy = tv_why.getText().toString().trim().trim();
        String startTime = start_time.getText().toString().trim();
        String endTime = end_time.getText().toString().trim();
        if (TextUtils.isEmpty(thy)) {
            BastToast("请输入请假原因");
        } else if (TextUtils.isEmpty(startTime)) {
            BastToast("请输入开始时间");
        } else if (TextUtils.isEmpty(endTime)) {
            BastToast("请输入结束时间");
        } else {
            int sert = mLeaveManagerDao.insert(class_number.getText().toString().trim(), user.getStudent_name(), startTime, endTime, thy, "等待审核");
            if (sert != -1) {
                Intent intent = new Intent();
                setResult(200, intent);
                BastToast("提交成功，等待审核");
                finish();
            } else {
                BastToast("提交失败");
            }
        }


    }
}