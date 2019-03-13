package com.zhuandian.cropmanager.entity;

import cn.bmob.v3.BmobObject;

/**
 * desc :
 * author：xiedong
 * date：2019/3/13
 */
public class CropEntity extends BmobObject {
    private String cropName;
    private int phMin;
    private int phMax;
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

    public int getPhMin() {
        return phMin;
    }

    public void setPhMin(int phMin) {
        this.phMin = phMin;
    }

    public int getPhMax() {
        return phMax;
    }

    public void setPhMax(int phMax) {
        this.phMax = phMax;
    }
}
