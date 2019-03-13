package com.zhuandian.cropmanager;


import com.zhuandian.cropmanager.base.BaseActivity;

public class ResultAcitivity extends BaseActivity {


    private String phLevel;
    private String cropName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_result;
    }

    @Override
    protected void setUpView() {
        phLevel = getIntent().getStringExtra("ph");
        cropName = getIntent().getStringExtra("crop_name");


    }
}
