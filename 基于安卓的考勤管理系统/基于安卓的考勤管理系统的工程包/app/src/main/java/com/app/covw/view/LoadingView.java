package com.app.covw.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.app.covw.R;


public class LoadingView extends Dialog {

    public LoadingView(@NonNull Context context) {
        this(context, R.style.loaddialog);
    }

    public LoadingView(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        onCreateView(context);
    }

    private void onCreateView(Context context) {
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.loading_layout);
    }


    @Override
    protected void onStart() {
        super.onStart();
        setCancelable(false);
    }
}
