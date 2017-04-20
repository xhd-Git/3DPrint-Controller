package com.realwork.reol.a3dprint_controller.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.realwork.reol.a3dprint_controller.IOUtils;
import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.stl.STLObject;
import com.realwork.reol.a3dprint_controller.stl.STLView;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;

import java.io.IOException;

public class StlViewAct extends BaseActivity{

    private STLObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stlPath = getIntent().getStringExtra("stlPath");
        try {

            byte[] bytes = IOUtils.toByteArray(getAssets().open(stlPath));
            object = new STLObject(bytes, mContext, new STLObject.IFinishCallBack() {
                @Override
                public void readstlfinish() {
                    Toast.makeText(mContext, "解析完成", Toast.LENGTH_SHORT).show();
                    if (object != null){
                        STLView stlView = new STLView(mContext, object);
                        setContentView(stlView);
                        stlView.requestRedraw();
                    } else {
                        setContentView(R.layout.activity_stl_view);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "解析失败", Toast.LENGTH_SHORT).show();
        }

        setLeftBack();
        getSupportActionBar().setTitle(getIntent().getStringExtra("name"));
    }
}
