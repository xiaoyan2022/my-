package com.app.covw.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.app.covw.R;


public class DelateDialog extends Dialog {

    public DelateDialog(@NonNull Context context) {
        this(context, R.style.loaddialog);
    }

    public DelateDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        onCreateView(context);
    }

    private void onCreateView(Context context) {
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.delate_layout);

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        findViewById(R.id.btn_delate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mDelateListener) {
                    mDelateListener.delate();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        setCancelable(false);
    }


    public DelateListener mDelateListener;


    public void setDelateListener(DelateListener delateListener) {
        mDelateListener = delateListener;
    }

    public interface DelateListener {
        void delate();
    }
}
