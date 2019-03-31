package com.zhuandian.cropmanager;


import android.os.Bundle;
import android.widget.TextView;

import com.zhuandian.cropmanager.base.BaseActivity;
import com.zhuandian.cropmanager.entity.CropEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ResultAcitivity extends BaseActivity {


    @BindView(R.id.tv_message)
    TextView tvMessage;
    private double phLevel;
    private String cropName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_result;
    }

    @Override
    protected void setUpView() {
        phLevel = getIntent().getDoubleExtra("ph", 0);
        cropName = getIntent().getStringExtra("crop_name");

        BmobQuery<CropEntity> query = new BmobQuery<>();

        query.addWhereEqualTo("cropName", cropName)
                .findObjects(new FindListener<CropEntity>() {
                    @Override
                    public void done(List<CropEntity> list, BmobException e) {
                        if (e == null) {
                            CropEntity cropEntity = list.get(0);
                            String huafei;
                            tvMessage.setText(String.format("传感器传递来的PH值为：%s\n 要查询的农作物名称为：%s\n 根据系统推荐 该农作物的的最适生长PH范围为 %s --%s \n 建议您施的肥料为: %s\n",
                                    phLevel, cropEntity.getCropName(), cropEntity.getPhMin(), cropEntity.getPhMax(), cropEntity.getPhMaxHuaFei()));
                        }

                    }
                });

    }


}
