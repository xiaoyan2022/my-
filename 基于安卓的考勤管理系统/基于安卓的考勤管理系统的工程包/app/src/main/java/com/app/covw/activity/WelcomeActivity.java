package com.app.covw.activity;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;

/**
 * 欢迎
 */
public class WelcomeActivity extends BaseActivity {

    private TextView tv_welcome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        tv_welcome = findViewById(R.id.tv_welcome);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        //设置动画
        ViewCompat.animate(tv_welcome).scaleX(1.0f).scaleY(1.0f).setDuration(800).setListener(new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {

            }

            @Override
            public void onAnimationEnd(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this, IdentityActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);
            }

            @Override
            public void onAnimationCancel(View view) {

            }
        });
    }
}