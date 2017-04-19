package com.realwork.reol.a3dprint_controller.entity;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by reol on 2017/4/19.
 */

public class MineFavoriteEntity {
    private Bitmap icon;
    private String title;
    private String info; // FIXME: 2017/4/19 还要分解，先做个视觉效果
    private int location;

    public MineFavoriteEntity(Bitmap icon, String title, String info, int location) {
        this.icon = icon;
        this.title = title;
        this.info = info;
        this.location = location;
    }

    public MineFavoriteEntity(String title, String info, int location) {
        this.title = title;
        this.info = info;
        this.location = location;
    }

    public MineFavoriteEntity() {
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public static ArrayList<MineFavoriteEntity> getDefaultList(){
        ArrayList<MineFavoriteEntity> list = new ArrayList<>();
        list.add(new MineFavoriteEntity());
        return list;
    }
}
