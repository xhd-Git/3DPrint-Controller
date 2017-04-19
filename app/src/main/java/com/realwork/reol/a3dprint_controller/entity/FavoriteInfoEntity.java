package com.realwork.reol.a3dprint_controller.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reol on 2017/4/19.
 */

public class FavoriteInfoEntity {
    private String title;
    private String number;

    public FavoriteInfoEntity(String title, String number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static ArrayList<FavoriteInfoEntity> getDefaultList(){
        ArrayList<FavoriteInfoEntity> list = new ArrayList<>(2);
        list.add(new FavoriteInfoEntity("本地模型文件","(0)"));
        list.add(new FavoriteInfoEntity("默认收藏","(0)"));

        return list;
    }
}
