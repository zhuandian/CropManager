package com.zhuandian.cropmanager.entity;

import cn.bmob.v3.BmobObject;

/**
 * desc :
 * author：xiedong
 * date：2019/3/13
 */
public class CropEntity extends BmobObject {
    private String cropName;
    private float phMin;
    private float phMax;
    private String phMinHuaFei;
    private String phMaxHuaFei;

    public String getPhMaxHuaFei() {
        return phMaxHuaFei;
    }

    public void setPhMaxHuaFei(String phMaxHuaFei) {
        this.phMaxHuaFei = phMaxHuaFei;
    }

    public String getPhMinHuaFei() {

        return phMinHuaFei;
    }

    public void setPhMinHuaFei(String phMinHuaFei) {
        this.phMinHuaFei = phMinHuaFei;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public float getPhMin() {
        return phMin;
    }

    public void setPhMin(float phMin) {
        this.phMin = phMin;
    }

    public float getPhMax() {
        return phMax;
    }

    public void setPhMax(float phMax) {
        this.phMax = phMax;
    }
}
