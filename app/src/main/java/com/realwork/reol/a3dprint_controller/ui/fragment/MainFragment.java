package com.realwork.reol.a3dprint_controller.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.ModelInfoEntity;
import com.realwork.reol.a3dprint_controller.ui.Adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/** 主界面
 * Created by reol on 2017/4/6.
 */

public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rl_no_data)
    RelativeLayout rlNoData;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout srlMain;
    @BindView(R.id.recycler_main)
    RecyclerView recyclerView;

    List<ModelInfoEntity> list = new ArrayList<>();

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<ModelInfoEntity> list = new ArrayList<>(3);

            ModelInfoEntity entity = new ModelInfoEntity();
            ModelInfoEntity entity1 = new ModelInfoEntity();
            ModelInfoEntity entity2 = new ModelInfoEntity();

            entity.setId(0x0011);
            entity.setName("小鸡叉");
            entity.setDescription("暂无简介");
            entity.setImgUrl("http://image.3dhoo.com/NewsDescImages/20161220/161220_091206_54084131.jpg");
            entity.setSize("225 kb");
            entity.setStlUrl("002.stl");

            entity1.setId(0x0100);
            entity1.setName("南瓜头");
            entity1.setDescription("暂无简介");
            entity1.setImgUrl("http://image.3dhoo.com/NewsDescImages/20160513/20160513_000233_795_26914.jpg");
            entity1.setSize("381 kb");
            entity1.setStlUrl("008.stl");

            entity2.setId(0x0101);
            entity2.setName("喷火龙");
            entity2.setDescription("暂无简介");
            entity2.setImgUrl("http://image.3dhoo.com/NewsDescImages/20160429/20160429_144938_811_Charizardstl.jpg");
            entity2.setSize("1783 kb");
            entity2.setStlUrl("011.stl");

            list.clear();

            list.add(entity);
            list.add(entity1);
            list.add(entity2);

            recyclerView.setAdapter(new RecyclerAdapter(getContext(),list));

            srlMain.setRefreshing(false);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ModelInfoEntity entity = new ModelInfoEntity();
        entity.setId(0x0000);
        entity.setName("小恐龙");
        entity.setDescription("一只可爱的小恐龙，像素风格，不会喷火，说不定有颈椎病");
        entity.setImgUrl("http://image.3dhoo.com/NewsDescImages/20160526/20160526_002614_775_gigazaurstl.jpg");
        entity.setSize("72 kb");
        entity.setStlUrl("005.stl");

        list.add(entity);

        ModelInfoEntity entity1 = new ModelInfoEntity();

        entity1.setId(0x0001);
        entity1.setName("小椅子");
        entity1.setDescription("暂无简介");
        entity1.setImgUrl("http://image.3dhoo.com/NewsDescImages/20160429/20160429_144145_717_chairbysamuelstl.jpg");
        entity1.setSize("83 kb");
        entity1.setStlUrl("012.stl");
        list.add(entity1);

        ModelInfoEntity entity2 = new ModelInfoEntity();

        entity2.setId(0x0010);
        entity2.setName("铃铛杯");
        entity2.setDescription("");
        entity2.setImgUrl("http://image.3dhoo.com/NewsDescImages/20160526/20160526_003654_306_vasostl.jpg");
        entity2.setSize("896 kb");
        entity2.setStlUrl("004.stl");
        list.add(entity2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main,container,false);
        ButterKnife.bind(this,view);

        srlMain.setColorSchemeColors(getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_red),
                getResources().getColor(R.color.google_yellow),
                getResources().getColor(R.color.google_green));

        srlMain.setOnRefreshListener(this);

        recyclerView.setAdapter(new RecyclerAdapter(getContext(),list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    mHandler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
