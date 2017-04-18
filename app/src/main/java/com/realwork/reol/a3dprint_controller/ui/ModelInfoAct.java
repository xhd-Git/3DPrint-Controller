package com.realwork.reol.a3dprint_controller.ui;

import android.os.Bundle;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.ModelInfoEntity;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;

public class ModelInfoAct extends BaseActivity {

    private ModelInfoEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_model_info);
        setLeftBack();

        entity = (ModelInfoEntity) getIntent().getSerializableExtra("model");
        getSupportActionBar().setTitle(entity.getName());
    }
}
