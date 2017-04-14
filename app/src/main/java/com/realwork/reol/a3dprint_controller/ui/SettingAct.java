package com.realwork.reol.a3dprint_controller.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;
import com.realwork.reol.a3dprint_controller.ui.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/** 设置页
 * Created by reol on 2017/4/12.
 */

public class SettingAct extends BaseActivity {

    @BindView(R.id.setting_content)
    FrameLayout content;

    private SettingFragment settingFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        settingFragment = new SettingFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.setting_content, settingFragment);

        transaction.commit();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
