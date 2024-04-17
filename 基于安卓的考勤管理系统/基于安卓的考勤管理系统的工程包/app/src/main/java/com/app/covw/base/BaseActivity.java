package com.app.covw.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.covw.view.LoadingView;


public abstract class BaseActivity extends AppCompatActivity {
    protected LoadingView mLoadingView;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
        setListener();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void setListener();

    protected abstract void initData();


    protected void BastToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showLoading() {
        if (mLoadingView == null && !isFinishing()) {
            mLoadingView = new LoadingView(this);
        }
        mLoadingView.show();
    }

    protected void hiddenDialog() {
        if (mLoadingView != null && mLoadingView.isShowing()) {
            mLoadingView.dismiss();
        }
    }
}
