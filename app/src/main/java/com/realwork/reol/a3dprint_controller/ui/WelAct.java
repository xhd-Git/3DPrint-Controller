package com.realwork.reol.a3dprint_controller.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelAct extends AppCompatActivity {
    @BindView(R.id.iv_wel)
    SimpleDraweeView imgWel;
    @BindView(R.id.tv_wel)
    TextView tvWel;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(WelAct.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        ButterKnife.bind(this);

        imgWel.setImageURI("https://xhd-git.github.io/HDSite/bs/bs_flush.png");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
