package com.realwork.reol.a3dprint_controller.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;

public class VersionInfoAct extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_info);
        setLeftBack();
    }
}
