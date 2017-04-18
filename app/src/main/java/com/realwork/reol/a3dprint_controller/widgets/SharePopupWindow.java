package com.realwork.reol.a3dprint_controller.widgets;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.ShareDataEntity;

import java.util.HashMap;
/** 分享专用弹窗
 * Created by reol on 2017/3/31.
 */

public class SharePopupWindow extends PopupWindow implements View.OnClickListener{
    private View mContentView;
    private ShareDataEntity mShareData;
    private Activity mAct;
    private WindowManager.LayoutParams layoutParams;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mAct.getWindow().setAttributes((WindowManager.LayoutParams) msg.obj);
                    break;
            }
        }
    };

    public SharePopupWindow(Activity activity, ShareDataEntity data) {
        LayoutInflater inflater = activity.getLayoutInflater();
        mContentView = inflater.inflate(R.layout.popup_share, null);

        mShareData = data;
        mAct = activity;

        this.setContentView(mContentView);
        this.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
        this.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setBackgroundDrawable(new ColorDrawable(Color.argb(127,0,0,0)));
        this.setAnimationStyle(R.style.PopupWindowFromBottom);


//        LinearLayout wechat = (LinearLayout) mContentView.findViewById(R.id.ll_share_wechat);
//        LinearLayout wechatTimeline = (LinearLayout) mContentView.findViewById(R.id.ll_share_wechat_timeline);
//        LinearLayout qq = (LinearLayout) mContentView.findViewById(R.id.ll_share_qq);
//        LinearLayout qzone = (LinearLayout) mContentView.findViewById(R.id.ll_share_qzone);
//        LinearLayout weibo = (LinearLayout) mContentView.findViewById(R.id.ll_share_weibo);
//        TextView shareCancel = (TextView) mContentView.findViewById(R.id.tv_share_cancel);

//        wechat.setOnClickListener(this);
//        wechatTimeline.setOnClickListener(this);
//        qq.setOnClickListener(this);
//        qzone.setOnClickListener(this);
//        weibo.setOnClickListener(this);
//        shareCancel.setOnClickListener(this);

        layoutParams = mAct.getWindow().getAttributes();
    }

    public void show(View parent){
        this.showAtLocation(parent, Gravity.BOTTOM,0,0);

        new Thread(new Runnable(){
            @Override
            public void run() {
                //此处while的条件alpha不能<= 否则会出现黑屏
                while(layoutParams.alpha > 0.5f){
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg =mHandler.obtainMessage();
                    msg.what = 1;
                    layoutParams.alpha -= 0.01f;
                    msg.obj = layoutParams;
                    mHandler.sendMessage(msg);
                }
            }
        }).start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        new Thread(new Runnable(){
            @Override
            public void run() {
                //此处while的条件alpha不能<= 否则会出现黑屏
                while(layoutParams.alpha < 1f){
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg =mHandler.obtainMessage();
                    msg.what = 1;
                    layoutParams.alpha += 0.01f;
                    msg.obj = layoutParams ;
                    mHandler.sendMessage(msg);
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.ll_share_qq:
//
//                break;
//            case R.id.ll_share_qzone:
//
//                break;
//            case R.id.ll_share_weibo:
//
//                break;
//            case R.id.tv_share_cancel:
//                if (this.isShowing()){
//                    this.dismiss();
//                }
//                break;
//        }
    }
}
