package com.realwork.reol.a3dprint_controller.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;

public class PrintHistoryAct extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_history);
        setLeftBack();
    }
}
