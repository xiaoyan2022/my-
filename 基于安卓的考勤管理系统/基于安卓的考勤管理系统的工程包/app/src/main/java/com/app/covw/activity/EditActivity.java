package com.app.covw.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.app.covw.R;
import com.app.covw.base.BaseActivity;
import com.app.covw.bean.JsonBean;
import com.app.covw.bean.UserInfo;
import com.app.covw.dao.UserDao;
import com.app.covw.utils.GetJsonDataUtil;
import com.app.covw.utils.SPUtils;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends BaseActivity {
    private TextView home, hometown;
    private EditText professional;
    private EditText signature;
    private Toolbar mToolbar;
    private Spinner spinner;
    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private String spinnerItemStr;
    private TextView username;
    private UserDao mUserDao;
    private EditText school;
    private EditText school_scl;


    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    protected void initViews() {

        mToolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.spinner);
        username = findViewById(R.id.username);
        home = findViewById(R.id.home);
        hometown = findViewById(R.id.hometown);
        professional = findViewById(R.id.professional);
        signature = findViewById(R.id.signature);
        school = findViewById(R.id.school);
        school_scl = findViewById(R.id.school_scl);


        list.add("单身");
        list.add("恋爱中");
        list.add("已婚");
        list.add("离异");
        list.add("丧偶");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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


        findViewById(R.id.edit_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserDao == null) {
                    mUserDao = new UserDao(EditActivity.this);
                }
                UserInfo info = SPUtils.getObject(EditActivity.this, "userInfo", UserInfo.class);
                int update = mUserDao.update(info.getUserName(), home.getText().toString().trim(), hometown.getText().toString().trim(), professional.getText().toString().trim(), spinnerItemStr, school.getText().toString().trim(), school_scl.getText().toString().trim(), signature.getText().toString());
                if (update == 1) {
                    SPUtils.saveObject(EditActivity.this, "userInfo", mUserDao.queryAll(info.getUserName()));
                    BastToast("修改成功");
                    Intent intent = new Intent();
                    setResult(200, intent);
                    finish();
                } else {
                    BastToast("修改失败");
                }

            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerView(home);
            }
        });

        hometown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerView(hometown);
            }
        });

    }

    @Override
    protected void initData() {
        UserInfo info = SPUtils.getObject(this, "userInfo", UserInfo.class);
        if (null != info) {
            username.setText("用户名：" + info.getUserName());
            signature.setText(info.getSignature());
            home.setText(info.getHome());
            hometown.setText(info.getHometown());
            professional.setText(info.getProfessional());
            school.setText(info.getSchool());
            school_scl.setText(info.getSchool_scl());
        }

        initJsonData();
    }


    private void showPickerView(TextView textView) {


        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";

                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";
                //如果tx 为null 说明没有选择地点
                textView.setText(opt1tx + "-" + opt2tx + "-" + opt3tx);
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();


    }


    private void initJsonData() {


        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                /*if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    city_AreaList.add("");
                } else {
                    city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }*/
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }

    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }
}