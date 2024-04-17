package com.app.covw.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择类型
 */
public class IdentityActivity extends BaseActivity {
    public static final int REQUEST_CODE = 200;
    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    //
    private Spinner spinner;
    private String spinnerItemStr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_identity;
    }

    @Override
    protected void initViews() {
        spinner = findViewById(R.id.spinner);
        list.add("管理员/教师");
        list.add("学生");

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

    @Override
    protected void initData() {

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data && resultCode == REQUEST_CODE) {
            Log.d("=============", "onActivityResult: ==========================");
            finish();
        }
    }

    public void go(View view) {

        if (spinnerItemStr.contains("管理员")) {
            Intent intent = new Intent(IdentityActivity.this, LoginActivity.class);
            intent.putExtra("identity", true);
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Intent intent = new Intent(IdentityActivity.this, LoginActivity.class);
            intent.putExtra("identity", false);
            startActivity(intent);
        }
    }
}