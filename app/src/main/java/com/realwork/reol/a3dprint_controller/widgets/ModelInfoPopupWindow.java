package com.realwork.reol.a3dprint_controller.widgets;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.ModelInfoEntity;

/**
 * Created by reol on 2017/4/18.
 */

public class ModelInfoPopupWindow extends PopupWindow implements View.OnClickListener {
    private ModelInfoEntity entity;
    private Activity context;
    private WindowManager.LayoutParams layoutParams;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    context.getWindow().setAttributes((WindowManager.LayoutParams) msg.obj);
                    break;
            }
        }
    };

    public ModelInfoPopupWindow(Activity context, ModelInfoEntity entity) {
        this.entity = entity;
        this.context = context;

        View contentView = LayoutInflater.from(context).inflate(R.layout.popup_model_info,null);
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        this.setContentView(contentView);
        this.setWidth(width - 20);
        this.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setBackgroundDrawable(new ColorDrawable(0x66000000));
        this.setElevation(16.0f);
        this.setAnimationStyle(R.style.PopupAlphaAnime);

//        ViewPager viewPager = (ViewPager) contentView.findViewById(R.id.popup_vp);
        SimpleDraweeView draweeView = (SimpleDraweeView) contentView.findViewById(R.id.popup_vp);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.popup_title);
        TextView tvDesp = (TextView) contentView.findViewById(R.id.popup_description);
        TextView tvLike = (TextView) contentView.findViewById(R.id.popup_favorite);
        TextView tvDownload = (TextView) contentView.findViewById(R.id.popup_download);
        TextView tvDetail = (TextView) contentView.findViewById(R.id.popup_detail);
        TextView tvPrint = (TextView) contentView.findViewById(R.id.popup_print);
        ImageView ivPoint = (ImageView) contentView.findViewById(R.id.popup_iv);
        LinearLayout llPoints = (LinearLayout) contentView.findViewById(R.id.popup_ll_guide);

        tvTitle.setText(entity.getName());
        tvDesp.setText(entity.getDescription());
        draweeView.setImageURI(entity.getImgUrl());
        tvLike.setOnClickListener(this);
        tvDownload.setOnClickListener(this);
        tvDetail.setOnClickListener(this);
        tvPrint.setOnClickListener(this);

//        final List<String> imgList = entity.getImgList();
//        List<SimpleDraweeView> viewList = new ArrayList<>(imgList.size());
//        SimpleDraweeView draweeView = new SimpleDraweeView(context);
//        for (int i = 0; i < imgList.size(); i++){
//            draweeView.setImageURI(imgList.get(i));
//            viewList.add(draweeView);
//        }
        layoutParams = context.getWindow().getAttributes();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popup_favorite:
                Toast.makeText(context, "i like this", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_detail:
                Toast.makeText(context, "check stl model", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_print:
                Toast.makeText(context, "let's print it", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_download:
                Toast.makeText(context, "download this", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void show(View parent){
        this.showAtLocation(parent, Gravity.CENTER,0,0);

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
}
