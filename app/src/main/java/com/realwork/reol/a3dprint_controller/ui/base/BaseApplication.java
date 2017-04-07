package com.realwork.reol.a3dprint_controller.ui.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by reol on 07/04/2017.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
