package com.realwork.reol.a3dprint_controller.ui.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by reol on 2017/4/6.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public ViewPagerAdapter(FragmentManager fm , List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
