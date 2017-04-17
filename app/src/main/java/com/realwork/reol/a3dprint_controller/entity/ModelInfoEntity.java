package com.realwork.reol.a3dprint_controller.entity;

/**
 * Created by reol on 2017/4/17.
 */

public class ModelInfoEntity {
    private int mid;
    private String name;
    private String description;
    private String size;
    private String imgUrl;
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
}
