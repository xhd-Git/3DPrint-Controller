package com.realwork.reol.a3dprint_controller.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;


/** Activity base
 * Created by reol on 07/04/2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
    }


}
