package com.realwork.reol.a3dprint_controller.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by reol on 2017/4/17.
 */

public class ModelInfoEntity implements Serializable{
    private int mid;
    private String name;
    private String description;
    private String size;
    private String imgUrl;
    private ArrayList<String> imgList; // 正式模型信息每个截图三张左右
    private String stlUrl;

    public ModelInfoEntity(int mid, String name, String description, String size, String imgUrl, String stlUrl) {
        this.mid = mid;
        this.name = name;
        this.description = description;
        this.size = size;
        this.imgUrl = imgUrl;
        this.stlUrl = stlUrl;
    }

    public ModelInfoEntity() {
    }

    public int getId() {
        return mid;
    }

    public void setId(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStlUrl() {
        return stlUrl;
    }

    public void setStlUrl(String stlUrl) {
        this.stlUrl = stlUrl;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public ArrayList<String> getImgList() {
        return imgList;
    }

    public void setImgList(ArrayList<String> imgList) {
        this.imgList = imgList;
    }

    public static ArrayList<ModelInfoEntity> defaultList(){
        ArrayList<ModelInfoEntity> list = new ArrayList<>();
        ModelInfoEntity entity = new ModelInfoEntity();
        entity.setName("小鸡叉");
        entity.setDescription("暂无简介");
        entity.setImgUrl("http://image.3dhoo.com/NewsDescImages/20161220/161220_091206_54084131.jpg");
        entity.setSize("225 kb");
        entity.setStlUrl("002.stl");


        return list;
    }
}
